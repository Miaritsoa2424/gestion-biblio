package com.springjpa.service;

import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.springjpa.entity.Inscription;
import com.springjpa.repository.InscriptionRepository;

@Service
public class InscriptionService {
    @Autowired
    private InscriptionRepository inscriptionRepository;

    public Inscription findById(Integer id){
        return inscriptionRepository.findById(id).get();
    }

    public List<Inscription> findAll(){
        return inscriptionRepository.findAll();
    }

    public void save(Inscription inscription){
        inscriptionRepository.save(inscription);
    }
}
