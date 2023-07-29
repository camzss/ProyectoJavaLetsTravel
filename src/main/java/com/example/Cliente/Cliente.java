package com.example.Cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cliente;

//    @NotBlank(message = "Debe ingresar un nombre")
    private String nombre;

//    @NotEmpty(message = "Debe ingresar su email")
//    @Email
    private String correo;

//    @NotBlank(message = "Debe ingresar un telefono")
    private String telefono;

    public Integer getId() {
        return id_cliente;
    }

    public void setId(Integer id) {
        this.id_cliente = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

//    public cliente(Integer id, String nombre, String email, String telefono) {
//        this.id = id;
//        this.nombre = nombre;
//        this.email = email;
//        this.telefono = telefono;
//    }
//


}
