package com.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.springjpa.entity.DureePret;

@Repository
public interface DureePretRepository extends JpaRepository<DureePret, Integer> {
    @Query(value = "SELECT * FROM duree_pret d WHERE d.id_profil = :idProfil", nativeQuery = true)
    DureePret findByIdProfil(@Param("idProfil") Integer idProfil);
}
