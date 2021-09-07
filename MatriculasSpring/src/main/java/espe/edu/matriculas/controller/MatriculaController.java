package espe.edu.matriculas.controller;

import espe.edu.matriculas.entities.Cuenta;
import espe.edu.matriculas.entities.Curso;
import espe.edu.matriculas.entities.Matricula;
import espe.edu.matriculas.entities.Persona;
import espe.edu.matriculas.payload.response.MessageResponse;
import espe.edu.matriculas.service.CuentaService;
import espe.edu.matriculas.service.CursoService;
import espe.edu.matriculas.service.MatriculaService;

import espe.edu.matriculas.service.PersonaService;
import espe.edu.matriculas.utils.SolicitudMatricula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    @Autowired
    MatriculaService matriculaService;

    @Autowired
    PersonaService personaService;

    @Autowired
    CursoService cursoService;

    @Autowired
    CuentaService cuentaService;

    @GetMapping("/{id}/list/cuentas")
    public List<Cuenta> listCursos(@PathVariable Long id){
        //return matriculaService.findById(id).getCuentas();
        return null;
    }

    @GetMapping("")
    public List<Matricula> list(){
        return matriculaService.findAll();
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> save(@RequestBody Matricula matricula){
        try{
            // set matricula reference for cuenta
            matricula.getCuenta().setMatricula(matricula);
            matriculaService.save(matricula);
            return ResponseEntity.ok().body(matricula);
        }catch (JpaSystemException e){
            return new ResponseEntity(new MessageResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @GetMapping("/{id}")
    public Matricula findByID(@PathVariable Long id){
        return matriculaService.findById(id);
    }

    @PostMapping("/matricular-persona")
    public ResponseEntity<?> matricularPersona(@RequestBody SolicitudMatricula solicitud){
        try {
            // verificacion de la existencia del estudiante
            if(!personaService.existsByCedula(solicitud.getCedula_persona()))return ResponseEntity.badRequest().body(new MessageResponse("La persona con la cédula: "+solicitud.getCedula_persona()+" no está registrada en la base de datos."));
            // verificacion de la existencia de la materia
            if(!cursoService.existsByNrc(solicitud.getNrc_curso())) return  ResponseEntity.badRequest().body(new MessageResponse("La materia con el nrc: "+solicitud.getNrc_curso()+" no está registrada en la base de datos."));

            // instancia de la persona y curso
            Persona persona = personaService.findByCedula(solicitud.getCedula_persona());
            Curso curso = cursoService.findByNrc(solicitud.getNrc_curso());

            // verificacion de que el estudiante no tiene cuentas pendientes
            List<Matricula> matriculas = persona.getMatriculas();
            int countCuentasPendientes = 0;
            for (Matricula m:
                 matriculas) {
                if(m.getCuenta().isEstado()==true) countCuentasPendientes++;
            }

            if(countCuentasPendientes>0) return ResponseEntity.badRequest().body(new MessageResponse("La persona: "+persona.getApellidos()+" "+persona.getNombres()+"  tiene: "+countCuentasPendientes+" cuentas pendientes"));

            Matricula matricula = new Matricula(curso, persona);
            matriculaService.save(matricula);
            Cuenta cuenta = new Cuenta( matricula);
            cuentaService.save(cuenta);
            return new ResponseEntity(new MessageResponse("La persona "+persona.getApellidos() + " " + persona.getNombres() + " se ha matriculado en " + curso.getMateria().getNombre() + " correctamente."), HttpStatus.CREATED);

        }catch (JpaSystemException e){
            return new ResponseEntity(new MessageResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
