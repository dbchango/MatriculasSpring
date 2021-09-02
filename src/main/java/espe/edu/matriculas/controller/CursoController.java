package espe.edu.matriculas.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import espe.edu.matriculas.service.PersonaService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/cursoss")

public class CursoController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PersonaService cursoService;

}
