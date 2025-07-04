package com.springjpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "restriction_categorie")
public class RestrictionCategorie {
    @EmbeddedId
    private RestrictionCategorieId id;

    @ManyToOne
    @MapsId("idCategorie")
    @JoinColumn(name = "id_categorie")
    private Categorie categorie;

    @ManyToOne
    @MapsId("idProfil")
    @JoinColumn(name = "id_profil")
    private Profil profil;

    public RestrictionCategorie() {}

    public RestrictionCategorie(RestrictionCategorieId id, Categorie categorie, Profil profil) {
        this.id = id;
        this.categorie = categorie;
        this.profil = profil;
    }

    public RestrictionCategorieId getId() { return id; }
    public void setId(RestrictionCategorieId id) { this.id = id; }
    public Categorie getCategorie() { return categorie; }
    public void setCategorie(Categorie categorie) { this.categorie = categorie; }
    public Profil getProfil() { return profil; }
    public void setProfil(Profil profil) { this.profil = profil; }
}