package espe.edu.matriculacion.repository;

import espe.edu.matriculacion.entities.Matricula;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface IMatriculacionRep {

    Matricula save(Matricula matricula) throws IOException, ExecutionException, InterruptedException;


}
