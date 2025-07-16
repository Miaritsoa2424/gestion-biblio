package com.springjpa.service;

import com.springjpa.entity.FinPret;
import com.springjpa.entity.Penalite;
import com.springjpa.entity.Pret;
import com.springjpa.entity.Retour;
import com.springjpa.repository.RetourRepository;
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

    @Autowired
    private PenaliteQuotaService penaliteQuotaService;

    public List<Retour> findAll() { return retourRepository.findAll(); }
    public Retour save(Retour retour) { return retourRepository.save(retour); }
    public void deleteById(Integer id) { retourRepository.deleteById(id); }
    public Retour findById(Integer id) { return retourRepository.findById(id).orElse(null); }
    public Retour findRetourByIdPret(Integer id) {return retourRepository.findRetourByPret(id);}

    public String retournerPret(Integer idPret,LocalDate dateRetour) throws Exception {
        
        try {
            Pret pret = pretService.findById(idPret);
            if (pret != null && retourService.findRetourByIdPret(idPret) == null) {
                Retour retour = new Retour();
                retour.setPret(pret);
                retour.setDateRetour(UtilService.toDateTimeWithCurrentTime(dateRetour));
                retourService.save(retour);
                LocalDateTime dateTime = UtilService.toDateTimeWithCurrentTime(dateRetour);

                FinPret finPret = pretService.findFinPret(pret);
                Penalite penalite2 = null;

                if (dateTime.isAfter(finPret.getDateFin())) {
                    List<Penalite> penalites = penaliteService.findByAdherantId(pret.getAdherant().getIdAdherant());
                        for (Penalite penalite : penalites) {
                            if (dateTime.isAfter(penalite.getDatePenalite()) && dateTime.isBefore(UtilService.ajouterJours(penalite.getDatePenalite(), penalite.getDuree()))) {
                                // long joursDeRetard = ChronoUnit.DAYS.between(finPret.getDateFin(), dateTime);
                                int joursDeRetard = penaliteQuotaService.findIdProfil(pret.getAdherant().getProfil().getIdProfil()).getDuree();
                                penalite2 = new Penalite();
                                penalite2.setAdherant(pret.getAdherant());
                                penalite2.setDuree(joursDeRetard);
                                penalite2.setDatePenalite(UtilService.ajouterJours(penalite.getDatePenalite(), penalite.getDuree()));
                                penaliteService.save(penalite2);
                                return "redirect:/pret";
                            }
                        }
                    // long joursDeRetard = ChronoUnit.DAYS.between(finPret.getDateFin(), dateTime);
                    Penalite penalite = new Penalite();
                    int joursDeRetard = penaliteQuotaService.findIdProfil(pret.getAdherant().getProfil().getIdProfil()).getDuree();
                    penalite.setAdherant(pret.getAdherant());
                    penalite.setDuree(joursDeRetard);
                    penalite.setDatePenalite(dateTime);

                    penaliteService.save(penalite);
                }
            } else {
                throw new Exception("Prêt non trouvé.");
            }
        } catch (Exception e) {
            throw e;
        }
        
        return "redirect:/pret";
    }
}