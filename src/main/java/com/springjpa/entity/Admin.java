
package com.springjpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "admin")
public class Admin {
    
    @Id
    @Column(name = "id_admin")
    private Integer idAdmin;
    
    @Column(name = "nom_admin", length = 50)
    private String nomAdmin;
    
    @Column(name = "prenom_admin", length = 50)
    private String prenomAdmin;
    
    @Column(name = "password", length = 50)
    private String password;
    
    // Constructeurs
    public Admin() {}
    
    public Admin(Integer idAdmin, String nomAdmin, String prenomAdmin, String password) {
        this.idAdmin = idAdmin;
        this.nomAdmin = nomAdmin;
        this.prenomAdmin = prenomAdmin;
        this.password = password;
    }
    
    // Getters et Setters
    public Integer getIdAdmin() {
        return idAdmin;
    }
    
    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }
    
    public String getNomAdmin() {
        return nomAdmin;
    }
    
    public void setNomAdmin(String nomAdmin) {
        this.nomAdmin = nomAdmin;
    }
    
    public String getPrenomAdmin() {
        return prenomAdmin;
    }
    
    public void setPrenomAdmin(String prenomAdmin) {
        this.prenomAdmin = prenomAdmin;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
