package com.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springjpa.entity.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
}
