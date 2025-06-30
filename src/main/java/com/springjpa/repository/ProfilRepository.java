package com.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springjpa.entity.Profil;

@Repository
public interface ProfilRepository extends JpaRepository<Profil, Integer> {
}
