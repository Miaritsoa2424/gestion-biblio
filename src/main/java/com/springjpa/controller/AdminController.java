package com.springjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springjpa.entity.Adherant;
import com.springjpa.entity.Admin;
import com.springjpa.service.AdminService;

import jakarta.servlet.http.HttpSession;

@RequestMapping("admin")
@Controller
public class AdminController {
    @Autowired
    AdminService adminService;


   @GetMapping("/login")
    public String loginForm(Model model) {
        return "admin-login";
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam("nom") String nom, 
                            @RequestParam("motDePasse") String motDePasse,
                            HttpSession session,
                            Model model) {
        Admin admin = adminService.authenticate(nom, motDePasse);
        
        if (admin != null) {
            session.setAttribute("admin", admin);
            return "redirect:/"; 
        } else {
            model.addAttribute("error", "Numéro d'adhérent ou mot de passe incorrect");
            return "admin-login";
        }
    }
}
