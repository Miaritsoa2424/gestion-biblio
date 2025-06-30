package com.springjpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "adherant")
public class Adherant {
    
    @Id
    @Column(name = "id_adherant")
    private Integer idAdherant;
    
    @Column(name = "nom_adherant", length = 50)
    private String nomAdherant;
    
    @Column(name = "prenom_adherant", length = 50)
    private String prenomAdherant;
    
    @Column(name = "password", length = 50)
    private String password;
    
    @ManyToOne
    @JoinColumn(name = "id_profil", nullable = false)
    private Profil profil;
    
    // Constructeurs
    public Adherant() {}
    
    public Adherant(Integer idAdherant, String nomAdherant, String prenomAdherant, 
                    String password, Profil profil) {
        this.idAdherant = idAdherant;
        this.nomAdherant = nomAdherant;
        this.prenomAdherant = prenomAdherant;
        this.password = password;
        this.profil = profil;
    }
    
    // Getters et Setters
    public Integer getIdAdherant() {
        return idAdherant;
    }
    
    public void setIdAdherant(Integer idAdherant) {
        this.idAdherant = idAdherant;
    }
    
    public String getNomAdherant() {
        return nomAdherant;
    }
    
    public void setNomAdherant(String nomAdherant) {
        this.nomAdherant = nomAdherant;
    }
    
    public String getPrenomAdherant() {
        return prenomAdherant;
    }
    
    public void setPrenomAdherant(String prenomAdherant) {
        this.prenomAdherant = prenomAdherant;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Profil getProfil() {
        return profil;
    }
    
    public void setProfil(Profil profil) {
        this.profil = profil;
    }
}