package com.springjpa.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springjpa.entity.JoursFerie;

@Repository
public interface JoursFerieRepository extends JpaRepository<JoursFerie, Integer>{}



