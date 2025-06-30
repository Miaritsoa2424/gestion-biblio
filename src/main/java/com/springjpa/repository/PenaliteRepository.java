package com.springjpa.repository;

import com.springjpa.entity.Penalite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PenaliteRepository extends JpaRepository<Penalite, Integer> {
    List<Penalite> findByAdherantIdAdherant(Integer idAdherant);
    Optional<Penalite> findTopByAdherantIdAdherantOrderByDatePenaliteDesc(Integer idAdherant);
}