package com.springjpa.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "statut_prolongement")
public class StatutProlongement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_statut_prolongement")
    private int id;

    @Column(name = "nom_statut")
    private String nomStatut;

    public StatutProlongement(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomStatut() {
        return nomStatut;
    }

    public void setNomStatut(String nomStatut) {
        this.nomStatut = nomStatut;
    }

}
