
package com.springjpa.entity;

import jakarta.persistence.Embeddable;


import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class QuotaTypePretId implements Serializable {
    
    private Integer idProfil;
    private Integer idTypePret;
    
    // Constructeurs
    public QuotaTypePretId() {}
    
    public QuotaTypePretId(Integer idProfil, Integer idTypePret) {
        this.idProfil = idProfil;
        this.idTypePret = idTypePret;
    }
    
    // Getters et Setters
    public Integer getIdProfil() {
        return idProfil;
    }
    
    public void setIdProfil(Integer idProfil) {
        this.idProfil = idProfil;
    }
    
    public Integer getIdTypePret() {
        return idTypePret;
    }
    
    public void setIdTypePret(Integer idTypePret) {
        this.idTypePret = idTypePret;
    }
    
    // equals et hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuotaTypePretId that = (QuotaTypePretId) o;
        return Objects.equals(idProfil, that.idProfil) && 
               Objects.equals(idTypePret, that.idTypePret);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idProfil, idTypePret);
    }
}
