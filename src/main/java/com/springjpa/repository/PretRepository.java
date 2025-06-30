package com.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springjpa.entity.Pret;

@Repository
public interface PretRepository extends JpaRepository<Pret, Integer> {
}
