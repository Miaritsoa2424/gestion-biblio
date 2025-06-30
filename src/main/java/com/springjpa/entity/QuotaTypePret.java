package com.springjpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;



@Entity
@Table(name = "quota_type_pret")
public class QuotaTypePret {
    
    @EmbeddedId
    private QuotaTypePretId id;
    
    @Column(name = "quota")
    private Integer quota;
    
    @ManyToOne
    @MapsId("idProfil")
    @JoinColumn(name = "id_profil")
    private Profil profil;
    
    @ManyToOne
    @MapsId("idTypePret")
    @JoinColumn(name = "id_type_pret")
    private TypePret typePret;
    
    // Constructeurs
    public QuotaTypePret() {}
    
    public QuotaTypePret(QuotaTypePretId id, Integer quota, Profil profil, TypePret typePret) {
        this.id = id;
        this.quota = quota;
        this.profil = profil;
        this.typePret = typePret;
    }
    
    // Getters et Setters
    public QuotaTypePretId getId() {
        return id;
    }
    
    public void setId(QuotaTypePretId id) {
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