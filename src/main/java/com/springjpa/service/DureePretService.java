package com.springjpa.service;

import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.springjpa.entity.DureePret;
import com.springjpa.repository.DureePretRepository;

@Service
public class DureePretService {
    @Autowired
    private DureePretRepository dureePretRepository;

    public DureePret findById(Integer id){
        return dureePretRepository.findById(id).get();
    }

    public List<DureePret> findAll(){
        return dureePretRepository.findAll();
    }

    public void save(DureePret dureePret){
        dureePretRepository.save(dureePret);
    }
}
