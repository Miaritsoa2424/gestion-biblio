package com.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springjpa.entity.Livre;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Integer> {
}
