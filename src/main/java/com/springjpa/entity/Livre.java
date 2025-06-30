
package com.springjpa.entity;

import java.util.Set;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "livre")
public class Livre {
    
    @Id
    @Column(name = "id_livre")
    private Integer idLivre;
    
    @Column(name = "titre", length = 50)
    private String titre;
    
    @Column(name = "isbn", length = 50)
    private String isbn;
    
    @Column(name = "langue", length = 50)
    private String langue;
    
    @Column(name = "annee_publication")
    private Integer anneePublication;
    
    @Column(name = "synopsis", length = 1000)
    private String synopsis;
    
    @Column(name = "nb_page")
    private Integer nbPage;
    
    @ManyToOne
    @JoinColumn(name = "id_editeur", nullable = false)
    private Editeur editeur;
    
    @ManyToOne
    @JoinColumn(name = "id_auteur", nullable = false)
    private Auteur auteur;
    
    @ManyToMany
    @JoinTable(
        name = "categorie_livre",
        joinColumns = @JoinColumn(name = "id_livre"),
        inverseJoinColumns = @JoinColumn(name = "id_categorie")
    )
    private Set<Categorie> categories;
    
    // Constructeurs
    public Livre() {}
    
    public Livre(Integer idLivre, String titre, String isbn, String langue, 
                 Integer anneePublication, String synopsis, Integer nbPage, 
                 Editeur editeur, Auteur auteur) {
        this.idLivre = idLivre;
        this.titre = titre;
        this.isbn = isbn;
        this.langue = langue;
        this.anneePublication = anneePublication;
        this.synopsis = synopsis;
        this.nbPage = nbPage;
        this.editeur = editeur;
        this.auteur = auteur;
    }
    
    // Getters et Setters
    public Integer getIdLivre() {
        return idLivre;
    }
    
    public void setIdLivre(Integer idLivre) {
        this.idLivre = idLivre;
    }
    
    public String getTitre() {
        return titre;
    }
    
    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public String getLangue() {
        return langue;
    }
    
    public void setLangue(String langue) {
        this.langue = langue;
    }
    
    public Integer getAnneePublication() {
        return anneePublication;
    }
    
    public void setAnneePublication(Integer anneePublication) {
        this.anneePublication = anneePublication;
    }
    
    public String getSynopsis() {
        return synopsis;
    }
    
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
    
    public Integer getNbPage() {
        return nbPage;
    }
    
    public void setNbPage(Integer nbPage) {
        this.nbPage = nbPage;
    }
    
    public Editeur getEditeur() {
        return editeur;
    }
    
    public void setEditeur(Editeur editeur) {
        this.editeur = editeur;
    }
    
    public Auteur getAuteur() {
        return auteur;
    }
    
    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }
    
    public Set<Categorie> getCategories() {
        return categories;
    }
    
    public void setCategories(Set<Categorie> categories) {
        this.categories = categories;
    }
}
