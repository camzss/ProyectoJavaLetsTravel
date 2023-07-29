package com.example.Agente;

import com.example.Agente.Agente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AgenteRepository extends JpaRepository<Agente,Long> {

    @Query("SELECT a FROM Agente a WHERE a.username = ?1 AND a.password = ?2")
    Agente findByUsernameAndPassword(String username, String password);
}
