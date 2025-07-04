package com.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springjpa.entity.FinPret;

@Repository
public interface FinPretRepository extends JpaRepository<FinPret, Integer> {
    
    @Query(value = "SELECT * FROM fin_pret f WHERE f.id_pret = :id_pret ORDER BY f.date_fin ASC LIMIT 1", nativeQuery = true)
    FinPret findByIdPret(@Param("id_pret") Integer id_pret);

    // @Query(value = "SELECT * FROM fin_pret f WHERE f.id_pret = :id_pret ORDER BY f.date_fin ASC LIMIT 1", nativeQuery = true)
    // FinPret findByIdPret(@Param("id_pret") Integer id_pret);

}
