package com.springjpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "quota_type_pret")
public class QuotaTypePret {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_quota_type_pret")
    private Integer id;

    @Column(name = "quota")
    private Integer quota;
    
    @ManyToOne
    @JoinColumn(name = "id_profil")
    private Profil profil;
    
    @ManyToOne
    @JoinColumn(name = "id_type_pret")
    private TypePret typePret;

    public QuotaTypePret(){}

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

    public TypePret getTypePret() {
        return typePret;
    }

    public void setTypePret(TypePret typePret) {
        this.typePret = typePret;
    }
}