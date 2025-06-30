
package com.springjpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "editeur")
public class Editeur {
    
    @Id
    @Column(name = "id_editeur")
    private Integer idEditeur;
    
    @Column(name = "nom_editeur", length = 50)
    private String nomEditeur;
    
    @Column(name = "localisation", length = 50)
    private String localisation;
    
    // Constructeurs
    public Editeur() {}
    
    public Editeur(Integer idEditeur, String nomEditeur, String localisation) {
        this.idEditeur = idEditeur;
        this.nomEditeur = nomEditeur;
        this.localisation = localisation;
    }
    
    // Getters et Setters
    public Integer getIdEditeur() {
        return idEditeur;
    }
    
    public void setIdEditeur(Integer idEditeur) {
        this.idEditeur = idEditeur;
    }
    
    public String getNomEditeur() {
        return nomEditeur;
    }
    
    public void setNomEditeur(String nomEditeur) {
        this.nomEditeur = nomEditeur;
    }
    
    public String getLocalisation() {
        return localisation;
    }
    
    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
}
