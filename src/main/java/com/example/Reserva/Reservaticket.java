package com.example.Reserva;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reservaticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_reserva;

    private Integer cantidadpersonas;
    private Integer cliente_id;
    private Integer agente_id;
    private Integer preciototal;
    private Integer viaje_id;
    private Date fechareserva;
    
    
    public Integer getId_reserva() {
        return id_reserva;
    }
    public void setId_reserva(Integer id_reserva) {
        this.id_reserva = id_reserva;
    }
    public Integer getCantidadpersonas() {
        return cantidadpersonas;
    }
    public void setCantidadpersonas(Integer cantidadpersonas) {
        this.cantidadpersonas = cantidadpersonas;
    }
    public Integer getCliente_id() {
        return cliente_id;
    }
    public void setCliente_id(Integer cliente_id) {
        this.cliente_id = cliente_id;
    }
    public Integer getAgente_id() {
        return agente_id;
    }
    public void setAgente_id(Integer agente_id) {
        this.agente_id = agente_id;
    }
    public Integer getPreciototal() {
        return preciototal;
    }
    public void setPreciototal(Integer preciototal) {
        this.preciototal = preciototal;
    }
    public Integer getViaje_id() {
        return viaje_id;
    }
    public void setViaje_id(Integer viaje_id) {
        this.viaje_id = viaje_id;
    }
    
    public Date getFechareserva() {
        return fechareserva;
    }
    public void setFechareserva(Date fechareserva) {
        this.fechareserva = fechareserva;
    }

    public Reservaticket(Integer id_reserva, Integer cantidadpersonas, Integer cliente_id, Integer agente_id,
            Integer preciototal, Integer viaje_id, Date fechareserva) {
        this.id_reserva = id_reserva;
        this.cantidadpersonas = cantidadpersonas;
        this.cliente_id = cliente_id;
        this.agente_id = agente_id;
        this.preciototal = preciototal;
        this.viaje_id = viaje_id;
        this.fechareserva = fechareserva;
    }
    public Reservaticket() {
    }
}