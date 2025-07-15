package com.springjpa.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "quota_prolongement")
public class QuotaProlongement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_quota_prolongement")
    private Integer id;

    @Column(name = "quota")
    private Integer quota;

    @ManyToOne
    @JoinColumn(name = "id_profil", nullable = false)
    private Profil profil;

    // === Constructeurs ===

    public QuotaProlongement() {
    }

    public QuotaProlongement(Integer quota, Profil profil) {
        this.quota = quota;
        this.profil = profil;
    }

    // === Getters et Setters ===

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }
}
