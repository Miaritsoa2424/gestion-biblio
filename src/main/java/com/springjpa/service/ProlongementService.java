package com.springjpa.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjpa.entity.Adherant;
import com.springjpa.entity.FinPret;
import com.springjpa.entity.Pret;
import com.springjpa.entity.Profil;
import com.springjpa.entity.Prolongement;
import com.springjpa.entity.ProlongementStatut;
import com.springjpa.repository.ProlongementRepository;

import jakarta.transaction.Transactional;

@Service
public class ProlongementService {
    @Autowired
    private ProlongementRepository prolongementRepository;

    @Autowired
    private ProfilService profilService;

    @Autowired
    private PretService pretService;

    @Autowired
    private AdherantService adherantService;

    @Autowired
    private ProlongementStatutService prolongementStatutService;

    @Autowired
    private QuotaProlongementService quotaProlongementService;

    @Autowired
    private StatutProlongementService statutProlongementService;

    public Prolongement findById(Integer id){
        return prolongementRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Aucun prolongement trouvé avec l'ID : " + id));
    }

    public int getNbrProlongementActif(Integer idAdherant,LocalDateTime dateTime){
        try {
            Adherant adherant = adherantService.findById(idAdherant);
            return prolongementRepository.countActifsByAdherant(adherant.getIdAdherant(),dateTime);

        } catch (Exception e) {
            throw e;
        }
    }

    public boolean peutProlonger(Adherant adherant,LocalDateTime dateTime){
        Profil profil = adherant.getProfil();
        Integer quotaProfil = quotaProlongementService.findQuotaByProfil(profil.getIdProfil());

        if (getNbrProlongementActif(adherant.getIdAdherant(), dateTime) >= quotaProfil) {
            return false;
        }
        return true;
    }

    @Transactional
    public Prolongement prolongerPret(Pret pret) throws Exception{
        try {
            Profil profil = pret.getAdherant().getProfil();
            Integer duree = profilService.getDureePret(profil.getIdProfil());

            if (!peutProlonger(pret.getAdherant(), LocalDateTime.now())) {
                throw new Exception("Quota de prolongement depassé");
            }


            Prolongement prolongement = new Prolongement();
            prolongement.setPret(pret);
    
            LocalDateTime dateFin = pretService.findFinPret(pret).getDateFin();
            
            prolongement.setDateFin(UtilService.ajouterJours(dateFin, duree));
            prolongement = prolongementRepository.save(prolongement);
            
            ProlongementStatut prolongement_statut = new ProlongementStatut();
            prolongement_statut.setDateChangement(LocalDateTime.now());
            prolongement_statut.setProlongement(prolongement);
            prolongement_statut.setStatutProlongement(statutProlongementService.findById(1));

            prolongementStatutService.save(prolongement_statut);
            return prolongement;
            
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Prolongement> findAllProlongementAttente(){
        return prolongementRepository.findAllProlongementAttente();
    }

    @Transactional
    public void validerProlongement(Integer idPrlg) throws Exception {
        try {
            Prolongement prolongement = findById(idPrlg);
    
            ProlongementStatut prolongementStatutNow = prolongementStatutService.getDernierStatutProlongement(idPrlg);
            int idEtatActuel = prolongementStatutNow.getStatutProlongement().getId();
    
            if (idEtatActuel == 2 || idEtatActuel == 3 || idEtatActuel == 4) {
                throw new Exception("Le prolongement est déjà dans l'état : " + idEtatActuel + ". L'action de validation est impossible.");
            }
    
            ProlongementStatut prolongementStatut = new ProlongementStatut();
            prolongementStatut.setDateChangement(LocalDateTime.now());
            prolongementStatut.setProlongement(prolongement);
            prolongementStatut.setStatutProlongement(statutProlongementService.findById(2)); 
            prolongementStatutService.save(prolongementStatut);

            FinPret finPret = pretService.findFinPret(prolongement.getPret());
            pretService.savePretProlonge(prolongement.getPret().getAdherant().getIdAdherant(), prolongement.getPret().getExemplaire(),
                                             finPret.getDateFin(), prolongement.getDateFin(), 1);
            
        } catch (Exception e) {
            throw e;
        }
    }
   
    public void refuserProlongement(Integer idPrlg) throws Exception{
        try {
            Prolongement prolongement = findById(idPrlg);
    
            ProlongementStatut prolongementStatutNow = prolongementStatutService.getDernierStatutProlongement(idPrlg);
            int idEtatActuel = prolongementStatutNow.getStatutProlongement().getId();
    
            if (idEtatActuel == 2 || idEtatActuel == 3 || idEtatActuel == 4) {
                throw new Exception("Le prolongement est déjà dans l'état : " + idEtatActuel + ". L'action de validation est impossible.");
            }

            ProlongementStatut prolongementStatut = new ProlongementStatut();
            prolongementStatut.setDateChangement(LocalDateTime.now());
            prolongementStatut.setStatutProlongement(statutProlongementService.findById(3));
            prolongementStatut.setProlongement(prolongement);
            prolongementStatutService.save(prolongementStatut);
    
        } catch (Exception e) {
            throw e;
        }
    }
}
