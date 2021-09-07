package espe.edu.matriculacion.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import espe.edu.matriculacion.entities.Cuenta;
import espe.edu.matriculacion.repository.CuentaRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class CuentaService implements ICuentaService{

    @Autowired
    CuentaRep cuentaRep;

    @Override
    public Cuenta save(Cuenta cuenta) throws ExecutionException, JsonProcessingException, InterruptedException {
        return cuentaRep.save(cuenta);
    }
}
