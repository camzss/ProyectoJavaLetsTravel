package com.example.Pais;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {


    @Query("SELECT p.nombre FROM Pais p WHERE p.id_pais = ?1")
    String findNombrePaisById(Integer paisId);
}
