package com.springjpa.service;

import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}
