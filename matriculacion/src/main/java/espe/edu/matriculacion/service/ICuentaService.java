package espe.edu.matriculacion.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import espe.edu.matriculacion.entities.Cuenta;

import java.util.concurrent.ExecutionException;

public interface ICuentaService {
    public Cuenta save(Cuenta cuenta) throws ExecutionException, JsonProcessingException, InterruptedException;
}
