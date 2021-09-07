package espe.edu.matriculas.controller;

import espe.edu.matriculas.entities.Carrera;
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
	CarreraService carreraService;
	
	@GetMapping("/{id}/list/materias")
	public List<Materia> listMaterias(@PathVariable Long id){
        return carreraService.findCarreraMaterias(id);
	}

	@PostMapping("")
	public Carrera save(@RequestBody Carrera carrera){
		carreraService.save(carrera);
		return carrera;

	}

	@GetMapping("/{id}")
	public Carrera save(@PathVariable Long id){
		return carreraService.findById(id);
	}
}
