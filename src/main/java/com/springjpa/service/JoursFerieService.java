package com.springjpa.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjpa.entity.JoursFerie;
import com.springjpa.repository.JoursFerieRepository;

@Service
public class JoursFerieService {

    @Autowired
    JoursFerieRepository joursFerieRepository;

    public boolean estJourFerie(LocalDateTime dateTime){
        List<JoursFerie> joursFeries = joursFerieRepository.findAll();
        for (JoursFerie joursFerie : joursFeries) {
            if (UtilService.estLeMemeJour(dateTime, joursFerie.getJour())) {
                return true;
            }
        }
        return false;
    }
}
