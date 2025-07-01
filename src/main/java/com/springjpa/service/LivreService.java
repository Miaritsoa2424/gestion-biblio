package com.springjpa.service;

import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springjpa.entity.Exemplaire;
import com.springjpa.entity.Livre;
import com.springjpa.repository.LivreRepository;

@Service
public class LivreService {
    @Autowired
    private LivreRepository livreRepository;

    public Livre findById(Integer id){
        return livreRepository.findById(id).get();
    }

    public List<Livre> findAll(){
        return livreRepository.findAll();
    }

    public void save(Livre livre){
        livreRepository.save(livre);
    }
    public List<Exemplaire> getExemplaireDispoLivre(int id_livre,Date date){
        List<Exemplaire> exemplaires = new ArrayList<>();
        



        return exemplaires;

    }
}
