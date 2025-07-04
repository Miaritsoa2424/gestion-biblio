package com.springjpa.service;

import com.springjpa.entity.Retour;
import com.springjpa.repository.RetourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RetourService {
    @Autowired
    private RetourRepository retourRepository;

    public List<Retour> findAll() { return retourRepository.findAll(); }
    public Retour save(Retour retour) { return retourRepository.save(retour); }
    public void deleteById(Integer id) { retourRepository.deleteById(id); }
    public Retour findById(Integer id) { return retourRepository.findById(id).orElse(null); }
}