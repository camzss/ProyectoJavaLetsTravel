package com.example.Login;

import com.example.Agente.AgenteRepository;
import com.example.Agente.Agente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Lupe
 */
@RestController
@CrossOrigin("http://localhost:3000")
public class LoginController {

    @Autowired
    private AgenteRepository agenteRepository;

    private Long UsuarioLogueado;

    @PostMapping("/login")
    public String Login(@RequestBody LoginForm loginForm){
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        Agente agente =agenteRepository.findByUsernameAndPassword(username, password);
        if (agente != null) {
            try {
                this.UsuarioLogueado = agente.getId_agente();
            } catch (Exception e) {
                throw new RuntimeException("Error al obtener el ID del usuario", e);
            }
            // Credentials are valid, redirect to home
            return "home";
        }
        return "login";
    }

    @GetMapping("/usuarioLogueado")
    public String getUsuarioLogueado() {
        return "usuario"+ UsuarioLogueado;
    }

//    @GetMapping("/usuarioLogueado")
//    public Long getUsuarioLogueado(Model model) {
//        model.addAttribute("usuarioLogueado", UsuarioLogueado);
//        return getUsuarioLogueado(); // Return the view for displaying the logged-in user ID
//    }

}
