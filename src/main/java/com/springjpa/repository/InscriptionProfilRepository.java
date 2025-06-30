package com.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springjpa.entity.InscriptionProfil;

@Repository
public interface InscriptionProfilRepository extends JpaRepository<InscriptionProfil, Integer> {
}
