package espe.edu.matriculas.controller;

import espe.edu.matriculas.entities.Cuenta;
import espe.edu.matriculas.entities.Persona;
import espe.edu.matriculas.payload.response.MessageResponse;
import espe.edu.matriculas.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/{id}/list/cuentas")
    public List<Cuenta> list(@PathVariable Long id){
        return personaService.findCuentas(id);
    }

    @PostMapping("")
    public Persona save(@RequestBody Persona persona){
        personaService.save(persona);
        return persona;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        personaService.delete(id);
    }

    @GetMapping("")
    public List<Persona> list(){
        return personaService.findAll();
    }

    @GetMapping("/{ci}/exists-by-cedula")
    public Boolean existsByCedula(@PathVariable String ci){
        return personaService.existsByCedula(ci);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        if(personaService.existsById(id)){
            return ResponseEntity.ok().body(personaService.findById(id));
        }else {
            return new ResponseEntity(new MessageResponse("La persona con el id: "+id+" no ha sido encontrada.") , HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/cuentas")
    public List<Cuenta> listCuentas(@PathVariable Long id){
        return personaService.findById(id).getCuentas();
    }

}
