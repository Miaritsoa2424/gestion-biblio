
package com.springjpa.entity;


import java.io.Serializable;

public class QuotaTypePretId implements Serializable {
    
    private Integer idProfil;
    private Integer idTypePret;
    
    // Constructeurs
    public QuotaTypePretId() {}
    
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
}
