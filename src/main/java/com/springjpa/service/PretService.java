package com.springjpa.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springjpa.entity.Adherant;
import com.springjpa.entity.Exemplaire;
import com.springjpa.entity.FinPret;
import com.springjpa.entity.Pret;
import com.springjpa.entity.Retour;
import com.springjpa.repository.FinPretRepository;
import com.springjpa.repository.PretRepository;
import com.springjpa.repository.RetourRepository;

@Service
public class PretService {
    @Autowired
    private PretRepository pretRepository;
    @Autowired
    private RetourRepository retourRepository;
    @Autowired
    private FinPretRepository finPretRepository;
    @Autowired
    private AdherantService adherantService;
    @Autowired
    private QuotaTypePretService quotaTypePretService;
    @Autowired
    private LivreService livreService;
    @Autowired
    private PenaliteService penaliteService;
    @Autowired
    private TypePretService typePretService;
    @Autowired
    private FinPretService finPretService;
    @Autowired
    private AdminService adminService;

    public Pret findById(Integer id) {
        return pretRepository.findById(id).get();
    }

    public List<Pret> findAll() {
        return pretRepository.findAll();
    }

    public void save(Pret pret) {
        pretRepository.save(pret);
    }

    public FinPret findFinPret(Pret pret) {
        return finPretRepository.findByIdPret(pret.getIdPret());
    }

    public Retour findRetourPret(Pret pret) {
        return retourRepository.findRetourByPret(pret.getIdPret());
    }

    public static boolean datesSeChevauchent(LocalDateTime debut1, LocalDateTime fin1,
            LocalDateTime debut2, LocalDateTime fin2) {
        return !fin1.isBefore(debut2) && !fin2.isBefore(debut1);
    }

    public List<Pret> findByNumeroAdherent(int numeroAdherent) {
        return pretRepository.findByNumeroAdherant(numeroAdherent);
    }

    public List<Pret> findByNomAdherant(String nom) {
        return pretRepository.findByNomAdherantContainingIgnoreCase(nom);
    }

    public List<Pret> findByTitreLivre(String titre) {
        return pretRepository.findByLivreTitreContainingIgnoreCase(titre);
    }

    public List<Pret> findByDate(LocalDate date) {
        LocalDateTime debut = date.atStartOfDay();
        LocalDateTime fin = date.plusDays(1).atStartOfDay();
        return pretRepository.findByDateDebutBetween(debut, fin);
    }

    public List<Pret> getPretsAvecProlongementEnAttente() {
        return pretRepository.findPretsAvecProlongementEnAttente(); // 1 = "en attente"
    }

    public void savePretProlonge(int adherantId,
            Exemplaire exemplaire,
            LocalDateTime dateTimeDebut,
            LocalDateTime dateTimeFin,
            int typePret) throws Exception {

        Adherant adherant = adherantService.findById(adherantId);
        if (adherant == null) {
            throw new Exception("Adhérant inexistant.");
        }

        boolean depasseQuota = quotaTypePretService.adherantDepasseQuota(
                adherant.getIdAdherant(),
                adherant.getProfil().getIdProfil(),
                typePret);
        if (depasseQuota) {
            throw new Exception("Quota de prêt dépassé.");
        }

        if (!livreService.peutPreterLivre(adherant, livreService.findById(exemplaire.getLivre().getIdLivre()))) {
            throw new Exception(
                    "Vous ne pouvez pas emprunter ce livre à cause de votre âge ou du type de votre profil.");
        }

        if (penaliteService.isPenalise(dateTimeDebut, adherant.getIdAdherant())) {
            throw new Exception("Adhérant pénalisé.");
        }

        if (!adherantService.isActif(adherant.getIdAdherant(), dateTimeDebut)) {
            throw new Exception("Adhérant non inscrit.");
        }

        Pret pret = new Pret();
        pret.setAdherant(adherant);
        pret.setAdmin(adminService.findById(1));
        pret.setDateDebut(dateTimeDebut);
        pret.setExemplaire(exemplaire);
        pret.setTypePret(typePretService.findById(typePret));

        save(pret);

        FinPret finPret = new FinPret();
        finPret.setDateFin(dateTimeFin);
        finPret.setPret(pret);
        finPretService.save(finPret);
    }

}
