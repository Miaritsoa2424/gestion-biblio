package com.springjpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.springjpa.entity.Inscription;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {
  @Query(value = "SELECT * FROM inscription WHERE id_adherant = :adherantId ORDER BY date_debut DESC LIMIT 1", nativeQuery = true)
  Inscription findLastByAdherantId(@Param("adherantId") Integer adherantId);
}
