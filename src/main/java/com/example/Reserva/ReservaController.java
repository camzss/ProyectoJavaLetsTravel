package com.example.Reserva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ReservaController {
    @Autowired
    private ReservaRepository resRepositorio;

    @GetMapping({"/reservas"})
    List<Reservaticket>getAllReservas(){
        return resRepositorio.findAll();
    }

    @GetMapping("/reserva/{id}")
    Reservaticket getReservaById(@PathVariable Integer id){
        return resRepositorio.findById(id)
                .orElseThrow(()->new RuntimeException("Could not found the user with Id "+id));
    }

    @PostMapping("/newReserv")
    Reservaticket newReserva (@RequestBody Reservaticket newReserva) {
        return resRepositorio.save(newReserva);
    }

    @PutMapping("/reserva/{id}")
    Reservaticket updateCliente(@RequestBody Reservaticket newReserva, @PathVariable Integer id){
        return resRepositorio.findById(id)
                .map(reserva ->{
                    reserva.setId_reserva(newReserva.getId_reserva());
                    reserva.setCantidadpersonas(newReserva.getCantidadpersonas());
                    reserva.setCliente_id(newReserva.getCliente_id());
                    reserva.setAgente_id(newReserva.getAgente_id());
                    reserva.setPreciototal(newReserva.getPreciototal());
                    reserva.setViaje_id(newReserva.getViaje_id());
                    reserva.setFechareserva(newReserva.getFechareserva());
                    return resRepositorio.save(reserva);
                }).orElseThrow(()->new RuntimeException("Could not found the user with Id "+id));
    }

    @DeleteMapping("reserva/{id}")
    String deleteReserv( @PathVariable Integer id){
        if (!resRepositorio.existsById(id)){
            throw new RuntimeException("Could not found the user with Id "+id);
        }
        resRepositorio.deleteById(id);
        return "User with Id: "+id+" has been deleted";
    }

}

