package com.springjpa.repository;
import com.springjpa.entity.Retour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RetourRepository extends JpaRepository<Retour, Integer> {
    @Query(value = "SELECT * from retour where id_pret = %:id_pret%",nativeQuery = true)
    Retour findRetourByPret(Integer id_pret);

}