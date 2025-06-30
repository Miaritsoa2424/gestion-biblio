package com.springjpa.service;

import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.springjpa.entity.Auteur;
import com.springjpa.repository.AuteurRepository;

@Service
public class AuteurService {
    @Autowired
    private AuteurRepository auteurRepository;

    public Auteur findById(Integer id){
        return auteurRepository.findById(id).get();
    }

    public List<Auteur> findAll(){
        return auteurRepository.findAll();
    }

    public void save(Auteur auteur){
        auteurRepository.save(auteur);
    }
}
