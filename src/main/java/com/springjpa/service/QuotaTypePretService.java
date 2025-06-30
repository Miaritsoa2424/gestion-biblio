package com.springjpa.service;

import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.springjpa.entity.QuotaTypePret;
import com.springjpa.repository.QuotaTypePretRepository;

@Service
public class QuotaTypePretService {
    @Autowired
    private QuotaTypePretRepository quotaTypePretRepository;

    public QuotaTypePret findById(Integer id){
        return quotaTypePretRepository.findById(id).get();
    }

    public List<QuotaTypePret> findAll(){
        return quotaTypePretRepository.findAll();
    }

    public void save(QuotaTypePret quotaTypePret){
        quotaTypePretRepository.save(quotaTypePret);
    }
}
