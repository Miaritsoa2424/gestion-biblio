package com.springjpa.service;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.springjpa.entity.QuotaProlongement;
import com.springjpa.repository.QuotaProlongementRepository;

@Service
public class QuotaProlongementService {
    @Autowired
    private QuotaProlongementRepository quotaProlongementRepository;

    public QuotaProlongement findById(Integer id){
        return quotaProlongementRepository.findById(id).get();
    }

    public List<QuotaProlongement> findAll(){
        return quotaProlongementRepository.findAll();
    }

    public void save(QuotaProlongement quotaProlongement){
        quotaProlongementRepository.save(quotaProlongement);
    }

    
    public int findQuotaByProfil(int idProfil) {

        return quotaProlongementRepository.findById(idProfil)
            .map(QuotaProlongement::getQuota)
            .orElseThrow(() -> new RuntimeException("Quota introuvable pour le profil ID " + idProfil));
        // QuotaProlongement quotaProlongement = quotaProlongementRepository.findByProfilIdProfil(idProfil).get();
        // int quota = 0;
        // if (quotaProlongement != null) {
        //     quota = quotaProlongement.getQuota();
        // }

        // return quota;
    }


}
