
package com.springjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springjpa.entity.*;
import com.springjpa.service.*;

import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/prolongement")
public class ProlongementController {

    @Autowired
    private PretService pretService;

    @Autowired
    private ProlongementService prolongementService;


    @PostMapping("/demander-prolongement")
    public String prolonger(
        @RequestParam("idPret") Integer idPret
    ) throws Exception{
        try {
            Pret pret = pretService.findById(idPret);
            prolongementService.prolongerPret(pret);
            return "redirect:/pret";
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @GetMapping("/prets-attente")
    public String afficherPretsEnAttente(Model model) {
        List<Pret> prets = pretService.getPretsAvecProlongementEnAttente();    
        model.addAttribute("prets", prets);
        return "prets-attente";
    }

    @GetMapping("/prolongement-list")
    public String afficherProlongementAttente(Model model){
        List<Prolongement> prolongements = prolongementService.findAllProlongementAttente();
        model.addAttribute("prolongements", prolongements);
        return "list-prolongement";
    }

    // // Pour "Valider" (idStatut = 2)
    @GetMapping("/valider")
    public String validerProlongement(@RequestParam("id") Integer idProlongement, RedirectAttributes redirectAttributes) {
        try {
            prolongementService.validerProlongement(idProlongement);
            redirectAttributes.addFlashAttribute("success", "Le prolongement a été validé avec succès.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erreur lors de la validation : " + e.getMessage());
        }
        return "redirect:prolongement-list";
    }

    @GetMapping("/refuser")
    public String refuserProlongement(@RequestParam("id") Integer idProlongement, RedirectAttributes redirectAttributes) {
        try {
            prolongementService.refuserProlongement(idProlongement);
            redirectAttributes.addFlashAttribute("success", "Le prolongement a été refusé .");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erreur lors du changement de statut : " + e.getMessage());
        }
        return "redirect:prolongement-list";
    }

}
 
    

