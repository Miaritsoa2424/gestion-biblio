package com.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springjpa.entity.Editeur;

@Repository
public interface EditeurRepository extends JpaRepository<Editeur, Integer> {
}
