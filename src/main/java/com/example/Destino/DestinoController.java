 package com.example.Destino;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Pais.PaisRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class DestinoController {
    @Autowired
    private DestinoRepository destinoFormRepository;
    @Autowired
    private PaisRepository paisRepository;   

  

    @GetMapping("/destino/{id}")
    Destino getDestinoById(@PathVariable Integer id) {
        return destinoFormRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find the destino with Id " + id));
    }


    @GetMapping("/destinos")
    List<DestinoCountry> getAllDestinos() {
        List<Destino> destinos = destinoFormRepository.findAll();
        List<DestinoCountry> destinosConPais = new ArrayList<>();

        for (Destino destino : destinos) {
            Integer paisId = destino.getIdPais();
            String nombrePais = paisRepository.findNombrePaisById(paisId);

            DestinoCountry destinoCountry = new DestinoCountry(
                    destino.getIdDestino(),
                    destino.getNombre(),
                    destino.getIdPais(),
                    destino.getPrecio(),
                    nombrePais
            );

            destinosConPais.add(destinoCountry);
        }

        return destinosConPais;
    }


    @PostMapping("/newdestino")
    Destino newDestino(@RequestBody Destino newDestino) {
        return destinoFormRepository.save(newDestino);
    }

    @PutMapping("/EditDestino/{id}")
    Destino updateDestino(@RequestBody Destino newDestino, @PathVariable Integer id) {
        return destinoFormRepository.findById(id)
                .map(destino -> {
                    destino.setNombre(newDestino.getNombre());
                    destino.setIdPais(newDestino.getIdPais());
                    destino.setPrecio(newDestino.getPrecio());
                    return destinoFormRepository.save(destino);
                })
                .orElseThrow(() -> new RuntimeException("Could not find the destino with Id " + id));
    }

    @DeleteMapping("/deletedestino/{id}")
    String deleteDestino(@PathVariable Integer id) {
        if (!destinoFormRepository.existsById(id)) {
            throw new RuntimeException("Could not find the destino with Id " + id);
        }
        destinoFormRepository.deleteById(id);
        return "Destino with Id: " + id + " has been deleted";
    }
}
