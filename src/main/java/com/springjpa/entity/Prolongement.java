package com.springjpa.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "prolongement")
public class Prolongement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prolongement")
    private int idProlongement;

    @Column(name = "date_fin")
    private LocalDateTime dateFin;

    @ManyToOne
    @JoinColumn(name = "id_pret", nullable = false)
    private Pret pret;

    @OneToMany(mappedBy = "prolongement", fetch = FetchType.LAZY)
    private List<ProlongementStatut> prolongementStatut;

    public int getIdProlongement() {
        return idProlongement;
    }

    public void setIdProlongement(int idProlongement) {
        this.idProlongement = idProlongement;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public Pret getPret() {
        return pret;
    }

    public void setPret(Pret pret) {
        this.pret = pret;
    }

    public List<ProlongementStatut> getProlongementStatut() {
        return prolongementStatut;
    }

    public void setProlongementStatut(List<ProlongementStatut> prolongementStatut) {
        this.prolongementStatut = prolongementStatut;
    }

}
