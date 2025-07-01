package com.springjpa.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "retour")
public class Retour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_retour")
    private Integer idRetour;

    @Column(name = "date_retour")
    private LocalDateTime dateRetour;

    @ManyToOne
    @JoinColumn(name = "id_pret")
    private Pret pret;

    // Getters & Setters
    public Integer getIdRetour() { return idRetour; }
    public void setIdRetour(Integer idRetour) { this.idRetour = idRetour; }
    public LocalDateTime getDateRetour() { return dateRetour; }
    public void setDateRetour(LocalDateTime dateRetour) { this.dateRetour = dateRetour; }
    public Pret getPret() { return pret; }
    public void setPret(Pret pret) { this.pret = pret; }
}