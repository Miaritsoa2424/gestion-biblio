package com.springjpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


import java.time.LocalDateTime;

@Entity
@Table(name = "inscription")
public class Inscription {
    
    @Id
    @Column(name = "id_inscription")
    private Integer idInscription;
    
    @Column(name = "date_inscription")
    private LocalDateTime dateInscription;
    
    @Column(name = "etat")
    private Boolean etat;
    
    @ManyToOne
    @JoinColumn(name = "id_adherant", nullable = false)
    private Adherant adherant;
    
    // Constructeurs
    public Inscription() {}
    
    public Inscription(Integer idInscription, LocalDateTime dateInscription, 
                       Boolean etat, Adherant adherant) {
        this.idInscription = idInscription;
        this.dateInscription = dateInscription;
        this.etat = etat;
        this.adherant = adherant;
    }
    
    // Getters et Setters
    public Integer getIdInscription() {
        return idInscription;
    }
    
    public void setIdInscription(Integer idInscription) {
        this.idInscription = idInscription;
    }
    
    public LocalDateTime getDateInscription() {
        return dateInscription;
    }
    
    public void setDateInscription(LocalDateTime dateInscription) {
        this.dateInscription = dateInscription;
    }
    
    public Boolean getEtat() {
        return etat;
    }
    
    public void setEtat(Boolean etat) {
        this.etat = etat;
    }
    
    public Adherant getAdherant() {
        return adherant;
    }
    
    public void setAdherant(Adherant adherant) {
        this.adherant = adherant;
    }
}