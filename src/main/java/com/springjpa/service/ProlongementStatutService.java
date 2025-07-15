package com.springjpa.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.springjpa.entity.Prolongement;
import com.springjpa.entity.ProlongementStatut;
import com.springjpa.repository.ProlongementStatutRepository;

@Service
public class ProlongementStatutService {
    @Autowired
    ProlongementStatutRepository prolongementStatutRepository;

    public ProlongementStatut save(ProlongementStatut prolongement_statut){
        // try {
        //     Prolongement prolongement = prolongement_statut.getProlongement();
        // } catch (Exception e) {
        //     throw e;
        // }
        return prolongementStatutRepository.save(prolongement_statut);
    }

    public ProlongementStatut getDernierStatutProlongement(Integer idProlongement) {
        ProlongementStatut statut = prolongementStatutRepository.getStatutProlongement(idProlongement);
        if (statut == null) {
            throw new NoSuchElementException("Aucun statut trouvé pour le prolongement avec l'ID : " + idProlongement);
        }
        return statut;
    }

    

}
