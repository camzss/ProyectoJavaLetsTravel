package com.example.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@RestController
@CrossOrigin("http://localhost:3000")

public class ClienteController {
    @Autowired
    private ClienteRepository cliRepositorio;

    @GetMapping({"/clientes"})
    List<Cliente>getAllClients(){
        return cliRepositorio.findAll();
    }

    @GetMapping("/cliente/{id}")
    Cliente getClienteById(@PathVariable Integer id){
        return cliRepositorio.findById(id)
                .orElseThrow(()->new RuntimeException("Could not found the user with Id "+id));
    }

    @PostMapping("/newclient")
    Cliente newCliente (@RequestBody Cliente newCliente) {
        return cliRepositorio.save(newCliente);
    }

    @PutMapping("/cliente/{id}")
    Cliente updateCliente(@RequestBody Cliente newCliente, @PathVariable Integer id){
        return cliRepositorio.findById(id)
                .map(cliente ->{
                    cliente.setNombre(newCliente.getNombre());
                    cliente.setCorreo(newCliente.getCorreo());
                    cliente.setTelefono(newCliente.getTelefono());
                    return cliRepositorio.save(cliente);
                }).orElseThrow(()->new RuntimeException("Could not found the user with Id "+id));
    }

    @DeleteMapping("cliente/{id}")
    String deleteClient( @PathVariable Integer id){
        if (!cliRepositorio.existsById(id)){
            throw new RuntimeException("Could not found the user with Id "+id);
        }
        cliRepositorio.deleteById(id);
        return "User with Id: "+id+" has been deleted";
    }

}
