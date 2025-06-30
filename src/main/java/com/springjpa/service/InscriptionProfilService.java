package com.springjpa.service;

import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.springjpa.entity.InscriptionProfil;
import com.springjpa.repository.InscriptionProfilRepository;

@Service
public class InscriptionProfilService {
    @Autowired
    private InscriptionProfilRepository inscriptionProfilRepository;

    public InscriptionProfil findById(Integer id){
        return inscriptionProfilRepository.findById(id).get();
    }

    public List<InscriptionProfil> findAll(){
        return inscriptionProfilRepository.findAll();
    }

    public void save(InscriptionProfil inscriptionProfil){
        inscriptionProfilRepository.save(inscriptionProfil);
    }
}
