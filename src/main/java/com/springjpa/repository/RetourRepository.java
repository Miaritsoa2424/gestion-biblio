package com.springjpa.repository;

import com.springjpa.entity.Retour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RetourRepository extends JpaRepository<Retour, Integer> {

    @Query(value = "SELECT * FROM retour WHERE id_pret = :id_pret", nativeQuery = true)
    Retour findRetourByPret(@Param("id_pret") Integer id_pret);
}
