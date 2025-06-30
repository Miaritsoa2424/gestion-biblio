package com.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springjpa.entity.Adherant;

@Repository
public interface AdherantRepository extends JpaRepository<Adherant, Integer> {
}
