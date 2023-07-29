package com.example.Destino;

public class DestinoCountry {
    private Integer idDestino;
    private String nombre;
    private Integer pais_id;
    private Integer precio;
    private String nombrePais;

    public DestinoCountry(Integer idDestino, String nombre, Integer pais_id, Integer precio, String nombrePais) {
        this.idDestino = idDestino;
        this.nombre = nombre;
        this.pais_id = pais_id;
        this.precio = precio;
        this.nombrePais = nombrePais;
    }

    public Integer getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(Integer idDestino) {
        this.idDestino = idDestino;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPais_id() {
        return pais_id;
    }

    public void setPais_id(Integer pais_id) {
        this.pais_id = pais_id;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }
}

