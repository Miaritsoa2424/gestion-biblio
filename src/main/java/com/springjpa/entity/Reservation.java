
package com.springjpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
public class Reservation {
    
    @Id
    @Column(name = "id_reservation")
    private Integer idReservation;
    
    @Column(name = "date_de_reservation")
    private LocalDateTime dateDeReservation;
    
    @ManyToOne
    @JoinColumn(name = "id_admin", nullable = false)
    private Admin admin;
    
    @ManyToOne
    @JoinColumn(name = "id_statut", nullable = false)
    private StatutReservation statut;
    
    @ManyToOne
    @JoinColumn(name = "id_exemplaire", nullable = false)
    private Exemplaire exemplaire;
    
    @ManyToOne
    @JoinColumn(name = "id_adherant", nullable = false)
    private Adherant adherant;
    
    // Constructeurs
    public Reservation() {}
    
    public Reservation(Integer idReservation, LocalDateTime dateDeReservation, 
                       Admin admin, StatutReservation statut, Exemplaire exemplaire, 
                       Adherant adherant) {
        this.idReservation = idReservation;
        this.dateDeReservation = dateDeReservation;
        this.admin = admin;
        this.statut = statut;
        this.exemplaire = exemplaire;
        this.adherant = adherant;
    }
    
    // Getters et Setters
    public Integer getIdReservation() {
        return idReservation;
    }
    
    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }
    
    public LocalDateTime getDateDeReservation() {
        return dateDeReservation;
    }
    
    public void setDateDeReservation(LocalDateTime dateDeReservation) {
        this.dateDeReservation = dateDeReservation;
    }
    
    public Admin getAdmin() {
        return admin;
    }
    
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    
    public StatutReservation getStatut() {
        return statut;
    }
    
    public void setStatut(StatutReservation statut) {
        this.statut = statut;
    }
    
    public Exemplaire getExemplaire() {
        return exemplaire;
    }
    
    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }
    
    public Adherant getAdherant() {
        return adherant;
    }
    
    public void setAdherant(Adherant adherant) {
        this.adherant = adherant;
    }
}
