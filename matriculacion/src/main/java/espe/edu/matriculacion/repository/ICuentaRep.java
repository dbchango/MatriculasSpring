package espe.edu.matriculacion.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import espe.edu.matriculacion.entities.Cuenta;
import espe.edu.matriculacion.entities.Matricula;

import java.util.concurrent.ExecutionException;

public interface ICuentaRep {
    Cuenta existsById(Long id);

    Cuenta save(Cuenta cuenta) throws JsonProcessingException, ExecutionException, InterruptedException;
}
