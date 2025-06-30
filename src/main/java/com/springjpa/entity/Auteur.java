package com.springjpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "auteur")
public class Auteur {
    
    @Id
    @Column(name = "id_auteur")
    private Integer idAuteur;
    
    @Column(name = "nom_auteur", nullable = false, length = 50)
    private String nomAuteur;
    
    @Column(name = "prenom_auteur", length = 50)
    private String prenomAuteur;
    
    // Constructeurs
    public Auteur() {}
    
    public Auteur(Integer idAuteur, String nomAuteur, String prenomAuteur) {
        this.idAuteur = idAuteur;
        this.nomAuteur = nomAuteur;
        this.prenomAuteur = prenomAuteur;
    }
    
    // Getters et Setters
    public Integer getIdAuteur() {
        return idAuteur;
    }
    
    public void setIdAuteur(Integer idAuteur) {
        this.idAuteur = idAuteur;
    }
    
    public String getNomAuteur() {
        return nomAuteur;
    }
    
    public void setNomAuteur(String nomAuteur) {
        this.nomAuteur = nomAuteur;
    }
    
    public String getPrenomAuteur() {
        return prenomAuteur;
    }
    
    public void setPrenomAuteur(String prenomAuteur) {
        this.prenomAuteur = prenomAuteur;
    }
}