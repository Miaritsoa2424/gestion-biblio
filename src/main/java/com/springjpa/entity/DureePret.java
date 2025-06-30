
package com.springjpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "duree_pret")
public class DureePret {
    
    @Id
    @Column(name = "id_duree_pret")
    private Integer idDureePret;
    
    @Column(name = "duree")
    private Integer duree;
    
    @ManyToOne
    @JoinColumn(name = "id_profil", nullable = false)
    private Profil profil;
    
    // Constructeurs
    public DureePret() {}
    
    public DureePret(Integer idDureePret, Integer duree, Profil profil) {
        this.idDureePret = idDureePret;
        this.duree = duree;
        this.profil = profil;
    }
    
    // Getters et Setters
    public Integer getIdDureePret() {
        return idDureePret;
    }
    
    public void setIdDureePret(Integer idDureePret) {
        this.idDureePret = idDureePret;
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
