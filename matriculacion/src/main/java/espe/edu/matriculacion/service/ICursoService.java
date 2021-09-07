package espe.edu.matriculacion.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import espe.edu.matriculacion.entities.Curso;
import espe.edu.matriculacion.entities.Persona;

import java.util.concurrent.ExecutionException;

public interface ICursoService {
    public Curso findByNrc(String nrc) throws ExecutionException, InterruptedException, JsonProcessingException;
    public Boolean existsByNrc(String nrc) throws ExecutionException, InterruptedException, JsonProcessingException;
}
