package com.springjpa.repository;

import java.time.LocalDateTime;
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

    @Query(value = """
    SELECT p.* 
    FROM pret p
    JOIN adherant ad ON ad.id_adherant = p.id_adherant 
    WHERE ad.numero_adherant = :numeroAdherent
    """, nativeQuery = true)
    List<Pret> findByNumeroAdherant(@Param("numeroAdherent") Integer numeroAdherent);


    @Query(value = """
    SELECT p.* 
    FROM pret p
    JOIN adherant ad ON ad.id_adherant = p.id_adherant 
    WHERE LOWER(ad.nom_adherant) LIKE LOWER(CONCAT('%', :nomAdherent, '%'))
    """, nativeQuery = true)
    List<Pret> findByNomAdherantContainingIgnoreCase(@Param("nomAdherent") String nomAdherent);

    @Query(value = """
    SELECT p.* 
    FROM pret p
    JOIN exemplaire e ON e.id_exemplaire = p.id_exemplaire
    JOIN livre l ON l.id_livre = e.id_livre
    WHERE LOWER(l.titre) LIKE LOWER(CONCAT('%', :titre, '%'))
    """, nativeQuery = true)
    List<Pret> findByLivreTitreContainingIgnoreCase(@Param("titre") String titre);

    List<Pret> findByDateDebutBetween(LocalDateTime dateDebut,LocalDateTime dateFin);
}
