package com.springjpa.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springjpa.entity.Adherant;
import com.springjpa.entity.Reservation;
import com.springjpa.repository.ReservationRepository;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private AdherantService adherantService;

    @Autowired
    private StatutReservationService statutReservationService;

    @Autowired
    private LivreService livreService;

    public Reservation findById(Integer id){
        return reservationRepository.findById(id).get();
    }

    public List<Reservation> findAll(){
        return reservationRepository.findAll();
    }

    public void save(Reservation reservation){
        reservationRepository.save(reservation);
    }

    public void reserverUnLivre(Integer id_adherant,Integer id_livre,LocalDateTime dateTime){
        Reservation resa = new Reservation(id_livre, dateTime, null, statutReservationService.findById(1), livreService.findById(id_livre), adherantService.findById(id_adherant));
        save(resa);
    }
}
