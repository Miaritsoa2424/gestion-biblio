package com.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springjpa.entity.PenaliteQuota;

@Repository
public interface PenaliteQuotaRepository extends JpaRepository<PenaliteQuota, Integer> {
    @Query(value = "SELECT * FROM penalite_quota WHERE id_profil = :idProfil", nativeQuery = true)
  PenaliteQuota findByIdProfil(@Param("idProfil") Integer idProfil);
}
