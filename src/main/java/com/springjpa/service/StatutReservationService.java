package com.springjpa.service;

import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.springjpa.entity.StatutReservation;
import com.springjpa.repository.StatutReservationRepository;

@Service
public class StatutReservationService {
    @Autowired
    private StatutReservationRepository statutReservationRepository;

    public StatutReservation findById(Integer id){
        return statutReservationRepository.findById(id).get();
    }

    public List<StatutReservation> findAll(){
        return statutReservationRepository.findAll();
    }

    public void save(StatutReservation statutReservation){
        statutReservationRepository.save(statutReservation);
    }
}
