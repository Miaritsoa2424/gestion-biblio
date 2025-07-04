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

    public Adherant getAdherantByNumero(int numero_adherant){
        List<Adherant> adherants = findAll();
        for (Adherant adherant : adherants) {
            if (adherant.getNumeroAdherant() == numero_adherant) {
                return adherant; // Retourne l'adhérent correspondant au numéro
            }
        }
        return null; // Aucun adhérent trouvé avec ce numéro
    }

    public Adherant authenticate(int numeroAdherant, String motDePasse) {
        Adherant adherant = getAdherantByNumero(numeroAdherant);
        if (adherant != null && adherant.getPassword().equals(motDePasse)) {
            return adherant;
        }
        return null;
    }

    public boolean peutReserver(Integer id_adherant) {
           if (isInscri(id_adherant) && !isPenalise(id_adherant)) {
                return true; // L'adhérent est inscrit et n'est pas pénalisé
            }
            return false; // L'adhérent est soit non inscrit, soit pénalisé
    }
    public boolean isAdmin(Adherant adherant) {
        if (adherant.getProfil().getNomProfil().equals("Admin")) {
            return true; // L'adhérent est un administrateur
        }
        return false; // L'adhérent n'est pas un administrateur
    }
}
