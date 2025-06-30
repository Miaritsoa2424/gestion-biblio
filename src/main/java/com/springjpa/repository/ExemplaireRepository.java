package com.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springjpa.entity.Exemplaire;

@Repository
public interface ExemplaireRepository extends JpaRepository<Exemplaire, Integer> {
}
