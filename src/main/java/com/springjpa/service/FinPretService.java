package com.springjpa.service;

import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.springjpa.entity.FinPret;
import com.springjpa.repository.FinPretRepository;

@Service
public class FinPretService {
    @Autowired
    private FinPretRepository finPretRepository;

    public FinPret findById(Integer id){
        return finPretRepository.findById(id).get();
    }

    public List<FinPret> findAll(){
        return finPretRepository.findAll();
    }

    public void save(FinPret finPret){
        finPretRepository.save(finPret);
    }
}
