package com.springjpa.dto;

import java.time.LocalDate;

public class AdherantDTO {
    private Integer idAdherant;
    private String nom;
    private String prenom;
    private Integer numero_adherant;
    private LocalDate dtn;
    private String nomProfil;
    private boolean estActif;
    private Integer quotaPretRestant;
    private boolean estPenalise;

    public AdherantDTO() {
    }

    public Integer getIdAdherant() {
        return idAdherant;
    }

    public void setIdAdherant(Integer idAdherant) {
        this.idAdherant = idAdherant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getNumero_adherant() {
        return numero_adherant;
    }

    public void setNumero_adherant(Integer numero_adherant) {
        this.numero_adherant = numero_adherant;
    }

    public LocalDate getDtn() {
        return dtn;
    }

    public void setDtn(LocalDate dtn) {
        this.dtn = dtn;
    }

    public String getNomProfil() {
        return nomProfil;
    }

    public void setNomProfil(String nomProfil) {
        this.nomProfil = nomProfil;
    }

    public boolean isEstActif() {
        return estActif;
    }

    public void setEstActif(boolean estActif) {
        this.estActif = estActif;
    }

    public Integer getQuotaPretRestant() {
        return quotaPretRestant;
    }

    public void setQuotaPretRestant(Integer quotaPretRestant) {
        this.quotaPretRestant = quotaPretRestant;
    }

    public boolean isEstPenalise() {
        return estPenalise;
    }

    public void setEstPenalise(boolean estPenalise) {
        this.estPenalise = estPenalise;
    }

}
