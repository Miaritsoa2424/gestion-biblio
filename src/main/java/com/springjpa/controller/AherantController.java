package com.springjpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.springjpa.service.AdherantService;
import com.springjpa.service.PenaliteService;
import com.springjpa.service.QuotaTypePretService;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.springjpa.dto.AdherantDTO;
import com.springjpa.entity.Adherant;
import com.springjpa.repository.QuotaProlongementRepository;
import com.springjpa.repository.QuotaTypePretRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/adherants")
@Controller
public class AherantController {
    @Autowired
    private AdherantService adherantService;

    @Autowired
    private QuotaTypePretService quotaTypePretService;

    @Autowired
    private QuotaTypePretRepository quotaTypePretRepository;

    @Autowired
    private PenaliteService penaliteService;

    @GetMapping("/login")
    public String loginForm(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam("numeroAdherant") int numeroAdherant, 
                            @RequestParam("motDePasse") String motDePasse,
                            HttpSession session,
                            Model model) {
        Adherant adherant = adherantService.authenticate(numeroAdherant, motDePasse);
        
        if (adherant != null) {
            session.setAttribute("adherant", adherant);
            if (adherantService.isAdmin(adherant)) {
                session.setAttribute("admin", adherant.getIdAdherant());
            }
            return "redirect:/livre/"; 
        } else {
            model.addAttribute("error", "Numéro d'adhérent ou mot de passe incorrect");
            return "login";
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneAdherant(@PathVariable Integer id) {
        Adherant adherant = adherantService.findById(id);
        if (adherant == null) {
            return ResponseEntity.notFound().build();
        }

        AdherantDTO dto = new AdherantDTO();
        dto.setIdAdherant(adherant.getIdAdherant());
        dto.setNom(adherant.getNomAdherant());
        dto.setPrenom(adherant.getNomAdherant());
        dto.setNumero_adherant(adherant.getNumeroAdherant());
        dto.setDtn(adherant.getDateNaissance());
        dto.setNomProfil(adherant.getProfil().getNomProfil());
        dto.setEstActif(adherantService.isActif(adherant.getIdAdherant(), LocalDateTime.now()));
        dto.setEstPenalise(penaliteService.isPenalise(LocalDateTime.now(), adherant.getIdAdherant()));
        dto.setQuotaPretRestant(quotaTypePretRepository.findQuota(adherant.getProfil().getIdProfil(), 1) - quotaTypePretService.countPretsEnCours(adherant.getIdAdherant(),1));

        return ResponseEntity.ok(dto);
    }
}
