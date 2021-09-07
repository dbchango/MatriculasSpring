package espe.edu.matriculacion.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import espe.edu.matriculacion.entities.Persona;

import java.util.concurrent.ExecutionException;

public interface IPersonaRep {

    Persona findByCedula(String ci) throws ExecutionException, InterruptedException, JsonProcessingException;

    Boolean existsByCedula(String ci) throws ExecutionException, InterruptedException, JsonProcessingException;

}
