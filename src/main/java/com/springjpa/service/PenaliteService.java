package com.springjpa.service;

import com.springjpa.entity.Penalite;
import com.springjpa.repository.AdherantRepository;
import com.springjpa.repository.PenaliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PenaliteService {

    @Autowired
    private PenaliteRepository penaliteRepository;

    @Autowired
    private AdherantRepository adherantRepository;

    public List<Penalite> findAll() {
        return penaliteRepository.findAll();
    }

    public Optional<Penalite> findById(Integer id) {
        return penaliteRepository.findById(id);
    }

    public List<Penalite> findByAdherantId(Integer idAdherant) {
        return penaliteRepository.findByAdherantIdAdherant(idAdherant);
    }

    public Penalite save(Penalite penalite) {
        return penaliteRepository.save(penalite);
    }

    public void deleteById(Integer id) {
        penaliteRepository.deleteById(id);
    }

    public boolean isPenalise(LocalDateTime date, Integer idAdherant){
        List<Penalite> penalites = penaliteRepository.findByAdherant(adherantRepository.findById(idAdherant).orElse(null));
        if (penalites.isEmpty()) {
            return false;
        }
        // Penalite lastpenalite = penalites.stream()
        //     .sorted(Comparator.comparing(penalite -> penalite.getDatePenalite().plusDays(penalite.getDuree())))
        //     .collect(Collectors.toList())
        //     .get(0);

        for (Penalite penalite2 : penalites) {
            LocalDateTime dateDebutPenalite = penalite2.getDatePenalite();
            LocalDateTime dateFinPenalite = UtilService.ajouterJours(dateDebutPenalite, penalite2.getDuree());
            if (date.isAfter(dateDebutPenalite) && date.isBefore(dateFinPenalite)) {
                return true;
            }
        }
        // return lastpenalite.getDatePenalite().plusDays(lastpenalite.getDuree()).isAfter(date) && lastpenalite.getDatePenalite().isBefore(date);
        return false;
    }
}