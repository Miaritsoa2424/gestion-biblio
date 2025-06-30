package com.springjpa.service;

import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.springjpa.entity.Adherant;
import com.springjpa.entity.Profil;
import com.springjpa.repository.AdherantRepository;
import com.springjpa.repository.InscriptionRepository;

@Service
public class AdherantService {
    @Autowired
    private AdherantRepository adherantRepository;

    @Autowired 
    private InscriptionRepository inscriptionRepository;

    @Autowired
    private ProfilService profilService;

    @Autowired
    private PenaliteService penaliteService;


    public Adherant findById(Integer id){
        return adherantRepository.findById(id).get();
    }

    public List<Adherant> findAll(){
        return adherantRepository.findAll();
    }

    public void save(Adherant adherant){
        adherantRepository.save(adherant);
    }

    public boolean isInscri(Integer adherantId) {
        var adherantOpt = adherantRepository.findById(adherantId);
        if (adherantOpt.isEmpty()) return false;
    
        var adherant = adherantOpt.get();
        // Récupérer la dernière inscription active
        var inscriptionOpt = inscriptionRepository.findTopByAdherantIdAdherantAndEtatOrderByDateInscriptionDesc(adherantId, true).get();
        if (inscriptionOpt == null) return false;

        // Verifier la duree de l'inscription pour le profil
        Profil profil = adherant.getProfil();
        var inscriptionProfil = profilService.getInscriptionProfilByProfil(profil);
        if (inscriptionProfil == null) return false;
        int duree = inscriptionProfil.getDuree(); 

        // Calcul de la date limite
        var dateLimite = inscriptionOpt.getDateInscription().plusDays(duree);
        return dateLimite.isAfter(java.time.LocalDateTime.now());
    }

    public boolean isPenalise(Integer adherantId) {
        return penaliteService.isPenalise(adherantId);
    }
}
