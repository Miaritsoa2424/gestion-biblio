
package com.springjpa.dto;

public class ExemplaireDTO {
    private Integer idExemplaire;
    private Boolean disponibilite;

    public ExemplaireDTO() {
    }

    public ExemplaireDTO(Integer idExemplaire, Boolean disponibilite) {
        this.idExemplaire = idExemplaire;
        this.disponibilite = disponibilite;
    }

    public Integer getIdExemplaire() {
        return idExemplaire;
    }

    public void setIdExemplaire(Integer idExemplaire) {
        this.idExemplaire = idExemplaire;
    }
    
    public Boolean getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(Boolean disponibilite) {
        this.disponibilite = disponibilite;
    }
}
 
    

