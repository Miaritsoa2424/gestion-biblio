package com.springjpa.service;

import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.oracle.wls.shaded.org.apache.bcel.generic.AALOAD;
import com.springjpa.entity.Adherant;
import com.springjpa.entity.Admin;
import com.springjpa.repository.AdminRepository;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public Admin findById(Integer id){
        return adminRepository.findById(id).get();
    }

    public List<Admin> findAll(){
        return adminRepository.findAll();
    }

    public void save(Admin admin){
        adminRepository.save(admin);
    }

    public Admin authenticate(String nomAdmin, String motDePasse) {
        List<Admin> listAdmins = adminRepository.findAll();
        for (Admin admin : listAdmins) {
            if (admin.getNomAdmin().equalsIgnoreCase(nomAdmin) && admin.getPassword().equals(motDePasse)) {
                return admin;
            }
        }
        return null;
    }
}
