package espe.edu.matriculas.controller;

import espe.edu.matriculas.entities.Cuenta;
import espe.edu.matriculas.service.MatriculaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/matriculas")

public class MatriculaController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    MatriculaService matriculaService;

    @GetMapping("/{id}/list/cuentas")
    public List<Cuenta> listCursos(@PathVariable Long id){
        return matriculaService.findById(id).getCuentas();
    }
}
