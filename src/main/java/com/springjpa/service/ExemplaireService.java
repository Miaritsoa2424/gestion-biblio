package com.springjpa.service;

import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.springjpa.entity.Exemplaire;
import com.springjpa.repository.ExemplaireRepository;

@Service
public class ExemplaireService {
    @Autowired
    private ExemplaireRepository exemplaireRepository;

    public Exemplaire findById(Integer id){
        return exemplaireRepository.findById(id).get();
    }

    public List<Exemplaire> findAll(){
        return exemplaireRepository.findAll();
    }

    public void save(Exemplaire exemplaire){
        exemplaireRepository.save(exemplaire);
    }
}
