package com.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springjpa.entity.Auteur;

@Repository
public interface AuteurRepository extends JpaRepository<Auteur, Integer> {
}
