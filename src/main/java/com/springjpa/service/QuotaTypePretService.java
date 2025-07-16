package com.springjpa.service;

import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.springjpa.entity.QuotaTypePret;
import com.springjpa.repository.PretRepository;
import com.springjpa.repository.QuotaTypePretRepository;

@Service
public class QuotaTypePretService {
    @Autowired
    private QuotaTypePretRepository quotaTypePretRepository;

    @Autowired
    private PretRepository pretRepository;

    public QuotaTypePret findById(Integer id){
        return quotaTypePretRepository.findById(id).get();
    }

    public List<QuotaTypePret> findAll(){
        return quotaTypePretRepository.findAll();
    }

    public void save(QuotaTypePret quotaTypePret){
        quotaTypePretRepository.save(quotaTypePret);
    }

    public Integer countPretsEnCours(Integer idAdherant,Integer idTypePret){
        return pretRepository.countPretsEnCours(idAdherant, idTypePret);
    }


    public boolean adherantDepasseQuota(Integer idAdherant, Integer idProfil, Integer idTypePret) {
        Integer quota = quotaTypePretRepository.findQuota(idProfil, idTypePret);
        if (quota == null) {
            return true;
        }
        int nbPrets = pretRepository.countPretsEnCours(idAdherant, idTypePret);
        return nbPrets >= quota;
    }
}
