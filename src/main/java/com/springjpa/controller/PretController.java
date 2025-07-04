package com.springjpa.controller;

import com.springjpa.entity.Adherant;
import com.springjpa.entity.Exemplaire;
import com.springjpa.entity.Pret;
import com.springjpa.service.AdherantService;
import com.springjpa.service.ExemplaireService;
import com.springjpa.service.LivreService;
import com.springjpa.service.PenaliteService;
import com.springjpa.service.PretService;
import com.springjpa.service.TypePretService;
import com.springjpa.service.UtilService;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PretController {

    @Autowired
    private ExemplaireService exemplaireService;

    @Autowired
    private AdherantService adherantService;

    @Autowired
    private LivreService livreService;

    @Autowired
    private TypePretService typePretService;

    @Autowired
    private PenaliteService penaliteService;

    @Autowired
    private PretService pretService;

    @GetMapping("/")
    public String index() {
        return "index"; // Redirection vers la page d'accueil
    }

    @GetMapping("/preter")
    public String preterLivreForm(Model model) {
        model.addAttribute("livres", livreService.findAll());
        model.addAttribute("typePrets", typePretService.findAll());
        return "pret";
    }

    @PostMapping("/preter")
    public String preterLivre(@RequestParam("adherent") int adherantId,
            @RequestParam("livre") int id_livre,
            @RequestParam("dateFin") LocalDate dateFinLocal,
            @RequestParam("dateDeb") LocalDate dateDebutLocal,
            @RequestParam("typePret") int typePret,
            Model model,
            RedirectAttributes redirectAttributes) {

        LocalDateTime dateTimeDebut = UtilService.toDateTimeWithCurrentTime(dateDebutLocal);
        LocalDateTime dateTimeFin = UtilService.toDateTimeWithCurrentTime(dateFinLocal);
        Adherant adherant = adherantService.getAdherantByNumero(adherantId);

        if (adherant == null) {
            redirectAttributes.addFlashAttribute("error", "Adhérant inexistant.");
            return "redirect:/preter";
        }

        Pret pretEffectue = livreService.preterLivre(id_livre, adherant, dateTimeDebut, dateTimeFin);

        if (penaliteService.isPenalise(dateTimeDebut, adherant.getIdAdherant()) == true) {
            redirectAttributes.addFlashAttribute("error", "Adhérant penalise.");
            return "redirect:/preter";
        }

        else if (!adherantService.isActif(adherant.getIdAdherant(), dateTimeDebut)) {
            redirectAttributes.addFlashAttribute("error", "Adhérant non inscris.");
            return "redirect:/preter";
        }

        else if (pretEffectue != null) {
            pretEffectue.setTypePret(typePretService.findById(typePret));
            pretService.save(pretEffectue);
            redirectAttributes.addFlashAttribute("success", "Prêt enregistré avec succès !");
        } else {
            redirectAttributes.addFlashAttribute("error", "Aucun exemplaire disponible pour cette période.");
        }

        return "redirect:/preter";
    }

}