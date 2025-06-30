package com.springjpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "inscription_profil")
public class InscriptionProfil {
    
    @Id
    @Column(name = "id_inscri_profil")
    private Integer idInscriProfil;
    
    @Column(name = "duree")
    private Integer duree;
    
    @ManyToOne
    @JoinColumn(name = "id_profil", nullable = false)
    private Profil profil;
    
    // Constructeurs
    public InscriptionProfil() {}
    
    public InscriptionProfil(Integer idInscriProfil, Integer duree, Profil profil) {
        this.idInscriProfil = idInscriProfil;
        this.duree = duree;
        this.profil = profil;
    }
    
    // Getters et Setters
    public Integer getIdInscriProfil() {
        return idInscriProfil;
    }
    
    public void setIdInscriProfil(Integer idInscriProfil) {
        this.idInscriProfil = idInscriProfil;
    }
    
    public Integer getDuree() {
        return duree;
    }
    
    public void setDuree(Integer duree) {
        this.duree = duree;
    }
    
    public Profil getProfil() {
        return profil;
    }
    
    public void setProfil(Profil profil) {
        this.profil = profil;
    }
}