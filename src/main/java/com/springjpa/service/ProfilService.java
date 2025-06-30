package com.springjpa.service;

import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springjpa.entity.InscriptionProfil;
import com.springjpa.entity.Profil;
import com.springjpa.repository.InscriptionProfilRepository;
import com.springjpa.repository.ProfilRepository;

@Service
public class ProfilService {
    @Autowired
    private ProfilRepository profilRepository;

    @Autowired
    private InscriptionProfilRepository inscriptionProfilRepository;

    public Profil findById(Integer id){
        return profilRepository.findById(id).get();
    }

    public List<Profil> findAll(){
        return profilRepository.findAll();
    }

    public void save(Profil profil){
        profilRepository.save(profil);
    }

    public InscriptionProfil getInscriptionProfilByProfil(Profil profil) {
        return inscriptionProfilRepository.findAll()
            .stream()
            .filter(ip -> ip.getProfil().getIdProfil().equals(profil.getIdProfil()))
            .findFirst()
            .orElse(null);
    }
}
