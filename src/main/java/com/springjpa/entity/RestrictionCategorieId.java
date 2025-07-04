package com.springjpa.entity;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.*;

@Embeddable
public class RestrictionCategorieId implements Serializable {
    private Integer idCategorie;
    private Integer idProfil;

    public RestrictionCategorieId() {}

    public RestrictionCategorieId(Integer idCategorie, Integer idProfil) {
        this.idCategorie = idCategorie;
        this.idProfil = idProfil;
    }

    public Integer getIdCategorie() { return idCategorie; }
    public void setIdCategorie(Integer idCategorie) { this.idCategorie = idCategorie; }
    public Integer getIdProfil() { return idProfil; }
    public void setIdProfil(Integer idProfil) { this.idProfil = idProfil; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RestrictionCategorieId)) return false;
        RestrictionCategorieId that = (RestrictionCategorieId) o;
        return Objects.equals(idCategorie, that.idCategorie) &&
               Objects.equals(idProfil, that.idProfil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategorie, idProfil);
    }
}