package com.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springjpa.entity.DureePret;

@Repository
public interface DureePretRepository extends JpaRepository<DureePret, Integer> {
}
