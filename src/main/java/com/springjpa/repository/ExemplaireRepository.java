package com.springjpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param; // à importer
import org.springframework.stereotype.Repository;

import com.springjpa.entity.Exemplaire;

@Repository
public interface ExemplaireRepository extends JpaRepository<Exemplaire, Integer> {

    @Query(value = "SELECT * FROM exemplaire e WHERE e.id_livre = :id_livre", nativeQuery = true)
    List<Exemplaire> findByIdLivre(@Param("id_livre") Integer id_livre);
}
