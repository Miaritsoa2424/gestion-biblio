package com.springjpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "profil")
public class Profil {
    
    @Id
    @Column(name = "id_profil")
    private Integer idProfil;
    
    @Column(name = "nom_profil", nullable = false, length = 50)
    private String nomProfil;
    
    @Column(name = "quota_pret")
    private Integer quotaPret;
    
    @Column(name = "quota_reservation")
    private Integer quotaReservation;
    
    // Constructeurs
    public Profil() {}
    
    public Profil(Integer idProfil, String nomProfil, Integer quotaPret, Integer quotaReservation) {
        this.idProfil = idProfil;
        this.nomProfil = nomProfil;
        this.quotaPret = quotaPret;
        this.quotaReservation = quotaReservation;
    }
    
    // Getters et Setters
    public Integer getIdProfil() {
        return idProfil;
    }
    
    public void setIdProfil(Integer idProfil) {
        this.idProfil = idProfil;
    }
    
    public String getNomProfil() {
        return nomProfil;
    }
    
    public void setNomProfil(String nomProfil) {
        this.nomProfil = nomProfil;
    }
    
    public Integer getQuotaPret() {
        return quotaPret;
    }
    
    public void setQuotaPret(Integer quotaPret) {
        this.quotaPret = quotaPret;
    }
    
    public Integer getQuotaReservation() {
        return quotaReservation;
    }
    
    public void setQuotaReservation(Integer quotaReservation) {
        this.quotaReservation = quotaReservation;
    }

}