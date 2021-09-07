package espe.edu.matriculacion.service;

import espe.edu.matriculacion.entities.Matricula;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface IMatriculaService {
    public Matricula save(Matricula matricula) throws IOException, ExecutionException, InterruptedException;
}
