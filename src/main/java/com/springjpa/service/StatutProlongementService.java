package com.springjpa.service;

import com.springjpa.entity.StatutProlongement;
import com.springjpa.repository.StatutProlongementRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatutProlongementService {

    @Autowired
    private StatutProlongementRepository repository;

    public List<StatutProlongement> findAll() {
        return repository.findAll();
    }

    public StatutProlongement save(StatutProlongement statut) {
        return repository.save(statut);
    }

    public StatutProlongement findById(Integer id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Statut prolongement ID " + id + " introuvable"));
    }
    public void delete(int id) {
        repository.deleteById(id);
    }
}
