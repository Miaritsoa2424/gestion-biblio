package com.springjpa.controller;

import com.springjpa.entity.Adherant;
import com.springjpa.entity.Exemplaire;
import com.springjpa.entity.Livre;
import com.springjpa.entity.Reservation;
import com.springjpa.service.AdherantService;
import com.springjpa.service.ExemplaireService;
import com.springjpa.service.LivreService;
import com.springjpa.service.ReservationService;
import com.springjpa.service.UtilService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/reservation")
@Controller
public class ReservationController {

    @Autowired
    private ExemplaireService exemplaireService;

    @Autowired
    private AdherantService adherantService;

    @Autowired
    private LivreService livreService;

    @Autowired
    private ReservationService reservationService;

    private UtilService utilService;

    @GetMapping("/reservation")
    public String formResa(Model model) {
        List<Livre> livres = livreService.findAll();

        model.addAttribute("books", livres);
        return "formReservation"; // Redirection vers la page d'accueil
    }

    @PostMapping("/reserveBook")
    public String reserverLivre(@RequestParam("livre") int id_livre,
                                @RequestParam("date") LocalDate date,
                                RedirectAttributes redirectAttributes) {
        try {
            Integer id_adherant = 1;
            LocalDateTime dateTime = UtilService.toDateTimeWithCurrentTime(date);
            reservationService.reserverUnLivre(id_adherant, id_livre, dateTime);
            redirectAttributes.addFlashAttribute("success", "Reservation reussi, passez au bibliotheque le ".concat(date.toString()));
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("success", "Echec lors de la reservation du livre");
        }
        return "redirect:/livre/detail?id=" + id_livre;
    }

}