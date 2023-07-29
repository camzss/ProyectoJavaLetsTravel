package com.example.Pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/paises")
public class PaisController {

    private final PaisRepository paisRepository;

    @Autowired
    public PaisController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @GetMapping
    public List<Pais> getAllPaises() {
        return paisRepository.findAll();
    }
}
