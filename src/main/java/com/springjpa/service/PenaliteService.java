package com.springjpa.service;

import com.springjpa.entity.Penalite;
import com.springjpa.repository.PenaliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PenaliteService {

    @Autowired
    private PenaliteRepository penaliteRepository;

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

    public boolean isPenalise(Integer adherantId) {
        Penalite penaliteOpt = penaliteRepository.findTopByAdherantIdAdherantOrderByDatePenaliteDesc(adherantId).orElse(null);
        if (penaliteOpt == null) return false;
        var finPenalite = penaliteOpt.getDatePenalite().plusDays(penaliteOpt.getDuree());
        return LocalDateTime.now().isBefore(finPenalite);
    }
}