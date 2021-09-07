package espe.edu.matriculacion.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import espe.edu.matriculacion.entities.Persona;

import java.util.concurrent.ExecutionException;

public interface IPersonaService {
    public Persona findByCedula(String ci) throws ExecutionException, InterruptedException, JsonProcessingException;
    public Boolean existsByCedula(String ci) throws ExecutionException, InterruptedException, JsonProcessingException;
}
