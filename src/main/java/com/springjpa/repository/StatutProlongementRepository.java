package com.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springjpa.entity.StatutProlongement;

@Repository
public interface StatutProlongementRepository extends JpaRepository<StatutProlongement, Integer> {}