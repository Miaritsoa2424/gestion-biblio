package com.springjpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "type_pret")
public class TypePret {
    
    @Id
    @Column(name = "id_type_pret")
    private Integer idTypePret;
    
    @Column(name = "type", length = 50)
    private String type;
    
    // Constructeurs
    public TypePret() {}
    
    public TypePret(Integer idTypePret, String type) {
        this.idTypePret = idTypePret;
        this.type = type;
    }
    
    // Getters et Setters
    public Integer getIdTypePret() {
        return idTypePret;
    }
    
    public void setIdTypePret(Integer idTypePret) {
        this.idTypePret = idTypePret;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
}
