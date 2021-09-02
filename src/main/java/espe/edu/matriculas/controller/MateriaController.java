package espe.edu.matriculas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import espe.edu.matriculas.entities.Carrera;
import espe.edu.matriculas.entities.Cuenta;
import espe.edu.matriculas.service.MateriaService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/materias")
public class MateriaController {
	@Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    MateriaService materiaService;
    
    @GetMapping("/{id}/list/carreras")
    public List<Carrera> listCarrera(@PathVariable Long id){
        return materiaService.findMateriaCarreras(id);
    }

}
