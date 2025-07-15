package com.springjpa.controller;

import com.springjpa.entity.Adherant;
import com.springjpa.entity.Livre;
import com.springjpa.service.LivreService;
import com.springjpa.service.ReservationService;
import com.springjpa.service.UtilService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.servlet.http.HttpSession;


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
    private LivreService livreService;

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservation")
    public String formResa(Model model) {
        List<Livre> livres = livreService.findAll();

        model.addAttribute("books", livres);
        return "formReservation"; // Redirection vers la page d'accueil
    }

    @PostMapping("/reserveBook")
    public String reserverLivre(@RequestParam("livre") int id_livre,
                                @RequestParam("date") LocalDate date,
                                HttpSession session,
                                RedirectAttributes redirectAttributes) {
        // try {
            Adherant adherant = (Adherant) session.getAttribute("adherant");
            LocalDateTime dateTime = UtilService.toDateTimeWithCurrentTime(date);
            reservationService.reserverUnLivre(adherant.getIdAdherant(), id_livre, dateTime);
            redirectAttributes.addFlashAttribute("success", "Reservation reussi, passez au bibliotheque le ".concat(date.toString()));
        // } catch (Exception e) {
        //     redirectAttributes.addFlashAttribute("error", "Echec lors de la reservation du livre:"+);
        // }
        return "redirect:/livre/detail?id=" + id_livre;
    }

}