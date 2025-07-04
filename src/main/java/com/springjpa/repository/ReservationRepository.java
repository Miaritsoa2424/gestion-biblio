package com.springjpa.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.springjpa.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Query(value = """
                SELECT * FROM reservation r
                JOIN reservation_statut rs ON r.id_reservation = rs.id_reservation
                WHERE rs.id_statut_reservation = 1
                  AND r.date_de_reservation BETWEEN :debut AND :fin
                  AND r.id_exemplaire = :idExemplaire
            """, nativeQuery = true)
    List<Reservation> findReservationsValidesParExemplaireEtDate(
            @Param("debut") LocalDateTime debut,
            @Param("fin") LocalDateTime fin,
            @Param("idExemplaire") Integer idExemplaire);

}
