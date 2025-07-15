package com.springjpa.controller;

import com.springjpa.entity.Adherant;
import com.springjpa.entity.Exemplaire;
import com.springjpa.entity.FinPret;
import com.springjpa.entity.Pret;
import com.springjpa.entity.Retour;
import com.springjpa.service.AdherantService;
import com.springjpa.service.ExemplaireService;
import com.springjpa.service.FinPretService;
import com.springjpa.service.LivreService;
import com.springjpa.service.PenaliteService;
import com.springjpa.service.PretService;
import com.springjpa.service.QuotaTypePretService;
import com.springjpa.service.RetourService;
import com.springjpa.service.TypePretService;
import com.springjpa.service.UtilService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PretController {

    @Autowired
    private AdherantService adherantService;

    @Autowired
    private QuotaTypePretService quotaTypePretService;

    @Autowired
    private LivreService livreService;

    @Autowired
    private TypePretService typePretService;

    @Autowired
    private PenaliteService penaliteService;

    @Autowired
    private PretService pretService;

    @Autowired
    private FinPretService finPretService;

    @Autowired
    private RetourService retourService;

    @Autowired
    private ExemplaireService exemplaireService;


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

        boolean depasseQuota = quotaTypePretService.adherantDepasseQuota(
                adherant.getIdAdherant(),
                adherant.getProfil().getIdProfil(),
                typePret);
        Boolean peutPreter = livreService.peutPreterLivre(adherant, livreService.findById(id_livre));
        Pret pretEffectue = livreService.preterLivre(id_livre, adherant, dateTimeDebut, dateTimeFin);

        if (depasseQuota) {
            redirectAttributes.addFlashAttribute("error", "Quota de prêt dépassé.");
            return "redirect:/preter";
        } else if (!peutPreter) {
            redirectAttributes.addFlashAttribute("error",
                    "Vous ne pouvez pas emprunter ce livre a cause de votre age ou du type de votre profil");
            return "redirect:/preter";
        }

        else if (adherant.equals(null)) {
            redirectAttributes.addFlashAttribute("error", "Adhérant inexistant.");
            return "redirect:/preter";
        } else if (penaliteService.isPenalise(dateTimeDebut, adherant.getIdAdherant()) == true) {
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
            FinPret finPret = new FinPret();
            finPret.setDateFin(dateTimeFin);
            finPret.setPret(pretEffectue);
            finPretService.save(finPret);
            redirectAttributes.addFlashAttribute("success", "Prêt enregistré avec succès !");
        } else {
            redirectAttributes.addFlashAttribute("error", "Aucun exemplaire disponible pour cette période.");
        }

        return "redirect:/preter";
    }

    @GetMapping("/pret")
    public String listPret(
            @RequestParam(required = false) Integer numeroAdherent,
            @RequestParam(required = false) String nom,
            @RequestParam(required = false) String titre,
            @RequestParam(required = false) String date,
            Model model) {

        List<Pret> prets;
        if (numeroAdherent != null) {
            prets = pretService.findByNumeroAdherent(numeroAdherent);
        } else if (nom != null && !nom.isEmpty()) {
            prets = pretService.findByNomAdherant(nom);
        } else if (titre != null && !titre.isEmpty()) {
            prets = pretService.findByTitreLivre(titre);
        } else if (date != null && !date.isEmpty()) {
            LocalDate searchDate = LocalDate.parse(date);
            prets = pretService.findByDate(searchDate);
        } else {
            prets = pretService.findAll();
        }

        model.addAttribute("prets", prets);
        return "list-pret";
    }

    @PostMapping("/detail-pret")
    public String retournerPret(
            @RequestParam("id") Integer idPret,
            @RequestParam("dateRetour") LocalDate dateRetour,
            RedirectAttributes redirectAttributes) {
        try {
            retourService.retournerPret(idPret, dateRetour);
            redirectAttributes.addFlashAttribute("success", "Retour enregistré avec succès !");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error",
                    "Erreur lors de l'enregistrement du retour:" + e.getMessage());
        }
        return "redirect:/pret";
    }

}