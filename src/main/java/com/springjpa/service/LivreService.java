package com.springjpa.service;

import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springjpa.entity.Adherant;
import com.springjpa.entity.Exemplaire;
import com.springjpa.entity.Livre;
import com.springjpa.entity.Pret;
import com.springjpa.repository.ExemplaireRepository;
import com.springjpa.repository.LivreRepository;

@Service
public class LivreService {
    @Autowired
    private LivreRepository livreRepository;

    @Autowired
    private ExemplaireRepository exemplaireRepository;

    @Autowired
    private ExemplaireService exemplaireService;

    @Autowired
    private PretService pretService;

    @Autowired
    private TypePretService typePretService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private ReservationService reservationService;

    public Livre findById(Integer id){
        return livreRepository.findById(id).get();
    }

    public List<Livre> findAll(){
        return livreRepository.findAll();
    }

    public void save(Livre livre){
        livreRepository.save(livre);
    }
    public List<Exemplaire> getExemplaireDispoLivre(int id_livre,Date date){
        List<Exemplaire> exemplaires = new ArrayList<>();
        return exemplaires;
    }

    public Pret preterLivre(int id_livre, Adherant adherant, LocalDateTime dateDebut, LocalDateTime dateFin) {
        List<Exemplaire> exemplaires = exemplaireRepository.findByIdLivre(id_livre);
    
        for (Exemplaire exemplaire : exemplaires) {
            if (exemplaireService.isExemplaireDisponible(exemplaire.getIdExemplaire(), dateDebut, dateFin)) {
                Pret pret = new Pret();
                pret.setAdherant(adherant);
                pret.setExemplaire(exemplaire);
                pret.setDateDebut(dateDebut);
                pret.setTypePret(typePretService.findById(1));
                pret.setAdmin(adminService.findById(1));
                return pret; // Prêt effectué
            }
        }
    
        return null; // Aucun exemplaire disponible
    }
    
}
