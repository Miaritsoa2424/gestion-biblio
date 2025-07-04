package com.springjpa.service;

import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.springjpa.entity.Exemplaire;
import com.springjpa.entity.FinPret;
import com.springjpa.entity.Pret;
import com.springjpa.entity.Retour;
import com.springjpa.repository.ExemplaireRepository;
import com.springjpa.repository.PretRepository;

@Service
public class ExemplaireService {
    @Autowired
    private ExemplaireRepository exemplaireRepository;
    @Autowired
    private PretRepository pretRepository;
    @Autowired
    private PretService pretService;

    public Exemplaire findById(Integer id){
        return exemplaireRepository.findById(id).get();
    }

    public List<Exemplaire> findAll(){
        return exemplaireRepository.findAll();
    }

    public void save(Exemplaire exemplaire){
        exemplaireRepository.save(exemplaire);
    }

    public List<Pret> findByIdExemplaire(Integer id_exemplaire){
        return pretRepository.findByIdExemplaire(id_exemplaire);
    }

    public Boolean isExemplaireDisponible(Integer id_exemplaire, LocalDateTime dateDebut, LocalDateTime dateFin) {
        List<Pret> prets = findByIdExemplaire(id_exemplaire);
        for (Pret pret : prets) {
            LocalDateTime dateDebutPret = pret.getDateDebut();
            LocalDateTime dateFinPretOuRetour = null;
    
            Retour retour = pretService.findRetourPret(pret);
            if (retour != null) {
                dateFinPretOuRetour = retour.getDateRetour();

            } else {
                return false;
            }
    
            if (dateFinPretOuRetour == null) continue;
    
            if (UtilService.periodesSeChevauchent(dateDebut, dateFin, dateDebutPret, dateFinPretOuRetour)) {
                return false;
            }
        }
        return true;
    }
    
   public List<Exemplaire> getExemplaireByIdLivre(int id_livre){
    return exemplaireRepository.findByIdLivre(id_livre);
   }


//    public boolean isExemplaireDisponible(int id_exemplaire, Date dateDebut, Date dateFin) {
//         LocalDateTime dateDebutLocal = dateDebut.toLocalDate().atStartOfDay();
//         LocalDateTime dateFinLocal = dateFin.toLocalDate().atStartOfDay();
//         return isExemplaireDisponible(id_exemplaire, dateDebutLocal, dateFinLocal);
//     }
}
