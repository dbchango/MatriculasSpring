package espe.edu.matriculas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import espe.edu.matriculas.entities.Materia;
import espe.edu.matriculas.service.CarreraService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/carreras")

public class CarreraController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	
	@Autowired
	CarreraService carreraService;
	
	@GetMapping("/{id}/list/materias")
	public List<Materia> listMaterias(@PathVariable Long id){
        return carreraService.findCarreraMaterias(id);
	}
}
