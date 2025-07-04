package com.springjpa.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.springjpa.entity.Adherant;
import com.springjpa.entity.Inscription;
import com.springjpa.repository.AdherantRepository;
import com.springjpa.repository.InscriptionRepository;

@Service
public class AdherantService {
    @Autowired
    private AdherantRepository adherantRepository;

    @Autowired
    private InscriptionRepository inscriptionRepository;


    public Adherant findById(Integer id) {
        return adherantRepository.findById(id).get();
    }

    public List<Adherant> findAll() {
        return adherantRepository.findAll();
    }

    public void save(Adherant adherant) {
        adherantRepository.save(adherant);
    }

    public Adherant getAdherantByNumero(int numero_adherant) {
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
        return true;
    }

    public boolean isAdmin(Adherant adherant) {
        if (adherant.getProfil().getNomProfil().equals("Admin")) {
            return true; 
        }
        return false; 
    }

    public boolean isActif(Integer adherantId, LocalDateTime datePret) {
        Inscription inscription = inscriptionRepository.findLastByAdherantId(adherantId);
        if (datePret.isAfter(inscription.getDateDebut()) && datePret.isBefore(inscription.getDateFin())) {
            return true;
        }

        return false;
    }
}
