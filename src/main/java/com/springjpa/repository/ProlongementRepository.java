package com.springjpa.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springjpa.entity.Prolongement;

@Repository
public interface ProlongementRepository extends JpaRepository<Prolongement, Integer> {
    // @Query(value = """
    //     SELECT p.*
    //     FROM prolongement p
    //     JOIN prolongement_statut ps ON p.id_prolongement = ps.id_prolongement
    //     WHERE ps.id_statut_prolongement = 2
    //     AND p.id_pret IN (
    //         SELECT pr.id_pret
    //         FROM pret pr
    //         WHERE pr.id_exemplaire = :idExemplaire
    //     )
    // """, nativeQuery = true)
    // List<Prolongement> findProlongementsEnCoursByExemplaire(@Param("idExemplaire") Integer idExemplaire);

    @Query(value = """
        SELECT COUNT(*) FROM prolongement p 
        JOIN prolongement_statut ps ON ps.id_prolongement = p.id_prolongement 
        JOIN statut_prolongement s ON s.id_statut_prolongement = ps.statut_prolongement
        JOIN pret pr ON pr.id_pret = p.id_pret
        WHERE pr.id_adherant = :idAdherant 
          AND p.date_fin > :now
          AND s.id_statut_prolongement = 2
    """, nativeQuery = true)
    int countActifsByAdherant(@Param("idAdherant") Integer idAdherant, @Param("now") LocalDateTime now);

    // @Query("SELECT p FROM Prolongement p WHERE p.pret.idPret = :idPret")
    // List<Prolongement> findByPretId(@Param("idPret") Integer idPret);

    @Query(value = """
            SELECT p.*
            FROM prolongement p
            JOIN (
                SELECT ps.id_prolongement, ps.statut_prolongement
                FROM prolongement_statut ps
                JOIN (
                    SELECT id_prolongement, MAX(date_changement) AS max_date
                    FROM prolongement_statut
                    GROUP BY id_prolongement
                ) latest
                ON ps.id_prolongement = latest.id_prolongement
                AND ps.date_changement = latest.max_date
                WHERE ps.statut_prolongement = 1
            ) AS derniers_statuts
            ON p.id_prolongement = derniers_statuts.id_prolongement;
            """,nativeQuery = true)
    List<Prolongement> findAllProlongementAttente();
}
