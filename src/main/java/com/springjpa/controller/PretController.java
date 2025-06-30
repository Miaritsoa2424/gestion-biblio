package com.springjpa.controller;

import com.springjpa.entity.Adherant;
import com.springjpa.entity.Exemplaire;
import com.springjpa.service.AdherantService;
import com.springjpa.service.ExemplaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PretController {

    @Autowired
    private ExemplaireService exemplaireService;

    @Autowired
    private AdherantService adherantService;


    @GetMapping("/")
    public String index() {
        return "index"; // Redirection vers la page d'accueil
    }

    @GetMapping("/preter")
    public String preter(Model model) {

        model.addAttribute("exemplaires", exemplaireService.findAll());
        model.addAttribute("adherants", adherantService.findAll());

        return "pret";
    }

    @PostMapping("/preter")
    public String preterLivre(@RequestParam("adherantId") int adherantId,
                              @RequestParam("exemplaires") int[] exemplaireIds, Model model) {
        Adherant adherant = adherantService.findById(adherantId);
        if (adherant.getIdAdherant() == null) {
            model.addAttribute("error", "Adhérant inexistant.");
            return "pret";
        }

        // 2. L'adhérant doit être inscrit (à adapter selon ta logique d'inscription)
        boolean inscrit = adherantService.isInscri(adherant.getIdAdherant());
        if (!inscrit) {
            model.addAttribute("error", "Adhérant non inscrit ou inscription inactive.");
            return "pret";
        }

        for (int exemplaireId : exemplaireIds) {
            // 3. Le numéro de l'exemplaire doit exister
            Exemplaire exemplaireOpt = exemplaireService.findById(exemplaireId);
            if (exemplaireOpt.getIdExemplaire() == null) {
                model.addAttribute("error", "Exemplaire n°" + exemplaireId + " inexistant.");
                return "pret";
            }

            // 4. L'exemplaire doit être disponible (pas déjà prêté)
            boolean disponible = exemplaireOpt.isDispo();
            if (!disponible) {
                model.addAttribute("error", "Exemplaire n°" + exemplaireId + " non disponible.");
                return "pret";
            }

            // 5. Vérifier si l'adhérant n'est pas pénalisé
            boolean penalise = adherantService.isPenalise(adherant.getIdAdherant()); 
            if (penalise) {
                model.addAttribute("error", "Adhérant pénalisé, prêt impossible.");
                return "pret";
            }

            // 6. Vérifier que l'adhérant ne dépasse pas le quota pour le type de prêt
            boolean depasseQuota = false; /* ...compte les prêts en cours de l'adhérant et compare au quota de son profil/type de prêt... */;
            if (depasseQuota) {
                model.addAttribute("error", "Quota de prêt dépassé.");
                return "pret";
            }

            // 7. L'adhérant peut-il prêter ce livre (ex: restrictions sur certains livres)
            // boolean peutPreter= false; /* ...vérifie les éventuelles restrictions (profil, catégorie, etc.)... */;
            // if (!peutPreter) {
            //     model.addAttribute("error", "Vous ne pouvez pas emprunter ce livre.");
            //     return "pret";
            // }
        }
        // Redirection vers la page de confirmation ou d'accueil après le prêt
        return "redirect:/";
        
    }
}