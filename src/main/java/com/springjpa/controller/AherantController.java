package com.springjpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.springjpa.service.AdherantService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.springjpa.entity.Adherant;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/adherants")
@Controller
public class AherantController {
    @Autowired
    private AdherantService adherantService;

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
            return "redirect:/livre/"; 
        } else {
            model.addAttribute("error", "Numéro d'adhérent ou mot de passe incorrect");
            return "login";
        }
    }
}
