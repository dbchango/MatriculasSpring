package espe.edu.matriculas.controller;

import espe.edu.matriculas.entities.Cuenta;
import espe.edu.matriculas.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/personas")
public class PersonaController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PersonaService personaService;

    @GetMapping("/{id}/list/cuentas")
    public List<Cuenta> listCuentas(@PathVariable Long id){
        return personaService.findPersonaCuentas(id);
    }
}
