package com.springjpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springjpa.entity.Inscription;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {
    Optional<Inscription> findTopByAdherantIdAdherantAndEtatOrderByDateInscriptionDesc(Integer adherantId, boolean etat);
}
