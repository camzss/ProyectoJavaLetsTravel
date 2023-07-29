
package com.example.Agente;

import com.example.Agente.AgenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Agente.Agente;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:3000")

public class AgenteController {

    @Autowired
    private AgenteRepository agenteRepository;

    @PostMapping("/agente")
    Agente newAgente(@RequestBody Agente newAgente){
        return agenteRepository.save(newAgente);
    }

    @GetMapping("/agentes")
    List<Agente> getAllAgentes(){
        return agenteRepository.findAll();
    }

    @GetMapping("agente/{id}")
    Agente getAgenteById(@PathVariable Long id){
        return agenteRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Could not found the agente with Id "+id));
    }

    @PutMapping("agente/{id}")
    Agente updateAgente(@RequestBody Agente newAgente, @PathVariable Long id){
        return agenteRepository.findById(id)
                .map(agente->{
                    agente.setNombre(newAgente.getNombre());
                    agente.setCorreo(newAgente.getCorreo());
                    agente.setUsername(newAgente.getUsername());
                    agente.setPassword(newAgente.getPassword());
                    return agenteRepository.save(agente);
                }).orElseThrow(()->new RuntimeException("Could not found the agente with Id "+id));
    }

    @DeleteMapping("agente/{id}")
    String deleteAgente(@PathVariable Long id){
        if (!agenteRepository.existsById(id)){
            throw new RuntimeException("Could not found the agente with Id "+id);
        }
        agenteRepository.deleteById(id);
        return "Agente with Id: "+ id+ " has been deleted";
    }

}
