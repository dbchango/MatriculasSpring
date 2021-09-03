package espe.edu.matriculas.controller;

import espe.edu.matriculas.entities.Cuenta;
import espe.edu.matriculas.payload.response.MessageResponse;
import espe.edu.matriculas.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    @Autowired
    CuentaService cuentaService;

    @GetMapping("")
    public List<Cuenta> list(){
        return cuentaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        if(cuentaService.existsById(id)){
            return ResponseEntity.ok(cuentaService.findById(id));
        }else {
            return new ResponseEntity(new MessageResponse("Cuenta no encontrada"), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public Cuenta save(@RequestBody Cuenta cuenta) throws JpaSystemException{
        cuentaService.save(cuenta);
        return cuenta;
    }



}
