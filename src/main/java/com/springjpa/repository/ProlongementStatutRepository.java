package com.springjpa.repository;

import org.springframework.stereotype.Repository;

import com.springjpa.entity.ProlongementStatut;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


@Repository
public interface ProlongementStatutRepository extends JpaRepository<ProlongementStatut, Integer>{
    @Query(value = """
            SELECT ps.* from prolongement p 
            join prolongement_statut ps on p.id_prolongement = ps.id_prolongement
            where p.id_prolongement = :idProlongement
            order by ps.date_changement
            desc LIMIT 1
            """,nativeQuery = true)
    ProlongementStatut getStatutProlongement(@Param("idProlongement")Integer idProlongement);    
}
