package com.springjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springjpa.entity.Categorie;
import com.springjpa.entity.Livre;
import com.springjpa.service.LivreService;
import com.springjpa.service.CategorieService;

import org.springframework.ui.Model;

@RequestMapping("/livre")
@Controller
public class LivreController {

    @Autowired
    private LivreService livreService;

    @Autowired
    private CategorieService categorieService;

    @GetMapping("/")
    public String livres(Model model) {
        List<Livre> livres = livreService.findAll();
        List<Categorie> categories = categorieService.findAll();
        
        model.addAttribute("livres", livres);
        model.addAttribute("categories", categories);

        return "listLivre"; // Redirection vers la page des livres
    }
    @GetMapping("/detail")
    public String detailLivre(Model model, Integer id) {
        Livre livre = livreService.findById(id);
        if (livre == null) {
            return "redirect:/livre/"; // Redirection si le livre n'existe pas
        }
        
        model.addAttribute("livre", livre);
        return "detailLivre"; // Redirection vers la page de détail du livre
    }
}
