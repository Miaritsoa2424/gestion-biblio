package com.springjpa.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springjpa.dto.ExemplaireDTO;
import com.springjpa.entity.Categorie;
import com.springjpa.entity.Exemplaire;
import com.springjpa.entity.Livre;
import com.springjpa.service.LivreService;
import com.springjpa.service.CategorieService;
import com.springjpa.service.ExemplaireService;

import org.springframework.ui.Model;

@RequestMapping("/livre")
@Controller
public class LivreController {

    @Autowired
    private LivreService livreService;

    @Autowired
    private CategorieService categorieService;

    @Autowired
    private ExemplaireService exemplaireService;

    @GetMapping("/")
    public String livres(Model model) {
        List<Livre> livres = livreService.findAll();
        List<Categorie> categories = categorieService.findAll();
        
        model.addAttribute("livres", livres);
        model.addAttribute("categories", categories);

        return "listLivre"; // Redirection vers la page des livres
    }
    // @GetMapping("/detail")
    // public String detailLivre(Model model, Integer id) {
    //     Livre livre = livreService.findById(id);
    //     if (livre == null) {
    //         return "redirect:/livre/"; // Redirection si le livre n'existe pas
    //     }
        
    //     model.addAttribute("livre", livre);
    //     return "detailLivre"; // Redirection vers la page de détail du livre
    // }

    @GetMapping("/detail")
    @ResponseBody
    public ResponseEntity<List<ExemplaireDTO>> getExemplaires(@RequestParam Integer id) {
        List<Exemplaire> exemplaires = exemplaireService.getExemplaireByIdLivre(id);

        List<ExemplaireDTO> dtos = exemplaires.stream().map(ex -> new ExemplaireDTO(
            ex.getIdExemplaire(),
            exemplaireService.isExemplaireDisponible(ex.getIdExemplaire(), LocalDateTime.now(), LocalDateTime.now())
        )).toList();

        return ResponseEntity.ok(dtos);
}


}
