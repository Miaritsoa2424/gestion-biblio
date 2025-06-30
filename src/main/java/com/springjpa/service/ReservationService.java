package com.springjpa.service;

import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.springjpa.entity.Reservation;
import com.springjpa.repository.ReservationRepository;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation findById(Integer id){
        return reservationRepository.findById(id).get();
    }

    public List<Reservation> findAll(){
        return reservationRepository.findAll();
    }

    public void save(Reservation reservation){
        reservationRepository.save(reservation);
    }
}
