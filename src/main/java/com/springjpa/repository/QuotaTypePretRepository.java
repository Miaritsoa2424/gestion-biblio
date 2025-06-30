package com.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springjpa.entity.QuotaTypePret;

@Repository
public interface QuotaTypePretRepository extends JpaRepository<QuotaTypePret, Integer> {
}
