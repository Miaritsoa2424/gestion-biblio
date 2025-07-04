package com.springjpa.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

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

    public Pret findById(Integer id){
        return pretRepository.findById(id).get();
    }

    public List<Pret> findAll(){
        return pretRepository.findAll();
    }

    public void save(Pret pret){
        pretRepository.save(pret);
    }

    public FinPret findFinPret(Pret pret){
        return finPretRepository.findByIdPret(pret.getIdPret());
    }

    public Retour findRetourPret(Pret pret){
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

    

}
