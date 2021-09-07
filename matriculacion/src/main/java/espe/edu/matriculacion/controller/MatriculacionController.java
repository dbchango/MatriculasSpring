package espe.edu.matriculacion.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import espe.edu.matriculacion.entities.Cuenta;
import espe.edu.matriculacion.entities.Curso;
import espe.edu.matriculacion.entities.Matricula;
import espe.edu.matriculacion.entities.Persona;
import espe.edu.matriculacion.payload.response.MessageResponse;
import espe.edu.matriculacion.service.CuentaService;
import espe.edu.matriculacion.service.CursoService;
import espe.edu.matriculacion.service.MatriculaService;
import espe.edu.matriculacion.service.PersonaService;
import espe.edu.matriculacion.utils.SolicitudMatricula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/matriculacion")
public class MatriculacionController {

    @Autowired
    PersonaService personaService;

    @Autowired
    CursoService cursoService;

    @Autowired
    MatriculaService matriculaService;

    @Autowired
    CuentaService cuentaService;

    private static final HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();

    @PostMapping("/matricular-persona")
    public ResponseEntity<?> matricularPersona(@RequestBody SolicitudMatricula solicitudMatricula) throws InterruptedException, ExecutionException, IOException {
        // verificacion de existencia de registros (persona | curso)
        if(!personaService.existsByCedula(solicitudMatricula.getCedula_persona())) return ResponseEntity.badRequest().body(new MessageResponse("La persona con la cédula: "+solicitudMatricula.getCedula_persona()+" no está registrada en la base de datos."));
        if(!cursoService.existsByNrc(solicitudMatricula.getNrc_curso()))return  ResponseEntity.badRequest().body(new MessageResponse("El curso con el nrc: "+solicitudMatricula.getNrc_curso()+" no existe en la base de datos."));
        // instancias de (persona | curso)
        Persona persona = personaService.findByCedula(solicitudMatricula.getCedula_persona());
        Curso curso = cursoService.findByNrc(solicitudMatricula.getNrc_curso());
        // lista de matriculas de la persona
        List<Matricula> matriculas = persona.getMatriculas();
        // contar el numero de cuentas pendientes
        int cuentasPendientes = 0;
        for (Matricula m:
             matriculas) {
            if(m.getCuenta().isEstado()==true) cuentasPendientes++;
        }

        // verificar que el numero de cuentas pendientes es 0 o el proceso no terminara
        if(cuentasPendientes>0 ) return ResponseEntity.badRequest().body(new MessageResponse("La persona: "+persona.getApellidos()+" "+persona.getNombres()+"  tiene: "+cuentasPendientes+" cuentas pendientes"));

        Matricula matricula = new Matricula();
        matricula.getCurso().setId(curso.getId());
        matricula.getPersona().setId(persona.getId());
        matricula.getCuenta().setEstado(true);
        matricula = matriculaService.save(matricula);
        return new ResponseEntity(new MessageResponse("La persona " + persona.getApellidos() + " " + persona.getNombres() + " se ha matriculado correctamente en el nrc: " + curso.getNrc() + "."), HttpStatus.CREATED);

    }
}
