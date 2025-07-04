package com.springjpa.repository;

import com.springjpa.entity.RestrictionCategorie;
import com.springjpa.entity.RestrictionCategorieId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RestrictionCategorieRepository extends JpaRepository<RestrictionCategorie, RestrictionCategorieId> {
    @Query(value = "SELECT EXISTS(SELECT 1 FROM restriction_categorie WHERE id_categorie = :idCategorie AND id_profil = :idProfil)", nativeQuery = true)
    int existsRestriction(@Param("idCategorie") Integer idCategorie, @Param("idProfil") Integer idProfil);
}