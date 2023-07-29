package com.example.Pais;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;


@Entity
public class Pais {
    @Id
    private Integer id_pais;
    
    private String nombre;

    // Otros campos y propiedades si los hay, así como los getters y setters

    // Constructor vacío
    public Pais() {}

    // Constructor con los campos principales
    public Pais(Integer id_pais, String nombre_pais) {
        this.id_pais = id_pais;
        this.nombre = nombre_pais;
    }

    // Getters y Setters
    public Integer getId_pais() {
        return id_pais;
    }

    public void setId_pais(Integer id_pais) {
        this.id_pais = id_pais;
    }

    public String getNombre_pais() {
        return nombre;
    }

    public void setNombre_pais(String nombre_pais) {
        this.nombre = nombre_pais;
    }
}

