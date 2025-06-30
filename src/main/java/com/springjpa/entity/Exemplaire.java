package com.springjpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "exemplaire")
public class Exemplaire {
    
    @Id
    @Column(name = "id_exemplaire")
    private Integer idExemplaire;
    
    @ManyToOne
    @JoinColumn(name = "id_livre", nullable = false)
    private Livre livre;

    @Column(name = "dispo")
    private boolean dispo;
    

    public Exemplaire() {
    }

    public Exemplaire(Integer idExemplaire, Livre livre, boolean dispo) {
        this.idExemplaire = idExemplaire;
        this.livre = livre;
        this.dispo = dispo;
    }

    // Getters et Setters
    public Integer getIdExemplaire() {
        return idExemplaire;
    }
    
    public void setIdExemplaire(Integer idExemplaire) {
        this.idExemplaire = idExemplaire;
    }
    
    public Livre getLivre() {
        return livre;
    }
    
    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public boolean isDispo() {
        return dispo;
    }

    public void setDispo(boolean dispo) {
        this.dispo = dispo;
    }
}