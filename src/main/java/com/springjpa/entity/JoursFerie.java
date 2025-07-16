package com.springjpa.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "jours_ferie")
public class JoursFerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jours_ferie")
    private Integer idJoursFerie;

    @Column(name = "jour", nullable = false)
    private LocalDate jour;

    // Constructeurs
    public JoursFerie() {}

    public JoursFerie(LocalDate jour) {
        this.jour = jour;
    }

    // Getters et setters
    public Integer getIdJoursFerie() {
        return idJoursFerie;
    }

    public void setIdJoursFerie(Integer idJoursFerie) {
        this.idJoursFerie = idJoursFerie;
    }

    public LocalDate getJour() {
        return jour;
    }

    public void setJour(LocalDate jour) {
        this.jour = jour;
    }
}
