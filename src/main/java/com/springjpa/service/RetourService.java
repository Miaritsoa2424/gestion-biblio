package com.springjpa.service;

import com.springjpa.entity.FinPret;
import com.springjpa.entity.Penalite;
import com.springjpa.entity.Pret;
import com.springjpa.entity.Retour;
import com.springjpa.repository.RetourRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class RetourService {
    @Autowired
    private RetourRepository retourRepository;

    @Autowired
    private PretService pretService;

    @Autowired
    private RetourService retourService;

    @Autowired
    private PenaliteService penaliteService;

    public List<Retour> findAll() { return retourRepository.findAll(); }
    public Retour save(Retour retour) { return retourRepository.save(retour); }
    public void deleteById(Integer id) { retourRepository.deleteById(id); }
    public Retour findById(Integer id) { return retourRepository.findById(id).orElse(null); }
    public Retour findRetourByIdPret(Integer id) {return retourRepository.findRetourByPret(id);}

    @Transactional
    public void retournerPret(Integer idPret,LocalDate dateRetour) throws Exception {
        
        try {
            Pret pret = pretService.findById(idPret);
            if (pret != null && retourService.findRetourByIdPret(idPret) == null) {
                Retour retour = new Retour();
                retour.setPret(pret);
                retour.setDateRetour(UtilService.toDateTimeWithCurrentTime(dateRetour));
                retourService.save(retour);
                LocalDateTime dateTime = UtilService.toDateTimeWithCurrentTime(dateRetour);

                FinPret finPret = pretService.findFinPret(pret);

                if (dateTime.isAfter(finPret.getDateFin())) {
                    long joursDeRetard = ChronoUnit.DAYS.between(finPret.getDateFin(), dateTime);
                    Penalite penalite = new Penalite();
                    penalite.setAdherant(pret.getAdherant());
                    penalite.setDuree((int) joursDeRetard);
                    penalite.setDatePenalite(dateTime);

                    penaliteService.save(penalite);
                }
            } else {
                throw new Exception("Prêt non trouvé.");
            }
        } catch (Exception e) {
            throw e;
        }        
    }
}