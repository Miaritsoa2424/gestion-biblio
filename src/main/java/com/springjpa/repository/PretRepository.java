package com.springjpa.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springjpa.entity.FinPret;
import com.springjpa.entity.Pret;

@Repository
public interface PretRepository extends JpaRepository<Pret, Integer> {

    @Query(value = "SELECT * FROM fin_pret f WHERE f.id_pret = %:id_pret% ORDER BY date_fin ASC limit 1",  nativeQuery = true)
    FinPret findByIdPret(Integer id_pret);

    @Query(value = "SELECT * FROM pret p WHERE p.id_exemplaire = %:id_exemplaire%", nativeQuery = true)
    List<Pret> findByIdExemplaire(Integer id_exemplaire);
}
