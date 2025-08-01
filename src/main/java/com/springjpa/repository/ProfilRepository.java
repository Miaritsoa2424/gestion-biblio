package com.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.springjpa.entity.Profil;

@Repository
public interface ProfilRepository extends JpaRepository<Profil, Integer> {
    @Query(value = """
        SELECT duree FROM duree_pret WHERE id_profil = :idProfil
        """, nativeQuery = true)
    int findDureePretByIdProfil(@Param("idProfil") int idProfil);
}
