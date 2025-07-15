package com.springjpa.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "prolongement_statut")
public class ProlongementStatut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prolongement_statut")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_prolongement")
    private Prolongement prolongement;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "statut_prolongement")
    private StatutProlongement statutProlongement;


    @Column(name = "date_changement")
    private LocalDateTime dateChangement;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Prolongement getProlongement() {
        return prolongement;
    }

    public void setProlongement(Prolongement prolongement) {
        this.prolongement = prolongement;
    }

    public StatutProlongement getStatutProlongement() {
        return statutProlongement;
    }

    public void setStatutProlongement(StatutProlongement statutProlongement) {
        this.statutProlongement = statutProlongement;
    }

    public LocalDateTime getDateChangement() {
        return dateChangement;
    }

    public void setDateChangement(LocalDateTime dateChangement) {
        this.dateChangement = dateChangement;
    }

   

}
