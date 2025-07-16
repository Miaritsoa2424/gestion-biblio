package com.springjpa.service;

import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springjpa.entity.PenaliteQuota;
import com.springjpa.repository.AdminRepository;
import com.springjpa.repository.PenaliteQuotaRepository;

@Service
public class PenaliteQuotaService {
    @Autowired
    private PenaliteQuotaRepository penaliteQuotaRepository;

    public PenaliteQuota findById(Integer id){
        return penaliteQuotaRepository.findById(id).get();
    }

    public List<PenaliteQuota> findAll(){
        return penaliteQuotaRepository.findAll();
    }

    public void save(PenaliteQuota admin){
        penaliteQuotaRepository.save(admin);
    }

    public PenaliteQuota findIdProfil(Integer idProfil){
        return penaliteQuotaRepository.findByIdProfil(idProfil);
    }
   
}
