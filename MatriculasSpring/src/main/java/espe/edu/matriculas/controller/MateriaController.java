package espe.edu.matriculas.controller;

import java.util.List;

import espe.edu.matriculas.entities.Curso;
import espe.edu.matriculas.entities.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import espe.edu.matriculas.entities.Carrera;
import espe.edu.matriculas.entities.Cuenta;
import espe.edu.matriculas.service.MateriaService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/materias")
public class MateriaController {

    @Autowired
    MateriaService materiaService;
    
    @GetMapping("/{id}/list/cursos")
    public List<Curso> listCarrera(@PathVariable Long id){
        return materiaService.findMateriaCursos(id);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Materia save(@RequestBody Materia materia){
        materiaService.save(materia);
        return materia;
    }

}
