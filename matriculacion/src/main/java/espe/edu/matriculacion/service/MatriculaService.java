package espe.edu.matriculacion.service;

import espe.edu.matriculacion.entities.Matricula;
import espe.edu.matriculacion.repository.MatriculaRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Service
public class MatriculaService implements IMatriculaService {

    @Autowired
    MatriculaRep matriculaRep;

    @Override
    public Matricula save(Matricula matricula) throws IOException, ExecutionException, InterruptedException {
        return matriculaRep.save(matricula);
    }
}
