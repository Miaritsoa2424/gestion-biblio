package com.springjpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param; 
import org.springframework.stereotype.Repository;

import com.springjpa.entity.Pret;

@Repository
public interface PretRepository extends JpaRepository<Pret, Integer> {   
    @Query(value = "SELECT * FROM pret p WHERE p.id_exemplaire = :id_exemplaire", nativeQuery = true)
    List<Pret> findByIdExemplaire(@Param("id_exemplaire") Integer id_exemplaire);

    @Query(value = "SELECT COUNT(*) FROM pret p WHERE p.id_adherant = :idAdherant AND p.id_type_pret = :idTypePret AND p.id_pret NOT IN (SELECT r.id_pret FROM retour r) ", nativeQuery = true)
    int countPretsEnCours(@Param("idAdherant") Integer idAdherant, @Param("idTypePret") Integer idTypePret);

}
