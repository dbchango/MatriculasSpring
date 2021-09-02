package espe.edu.matriculas.service;

import java.util.List;

import espe.edu.matriculas.entities.Cuenta;
import espe.edu.matriculas.entities.Matricula;

public interface IMatriculaService {
	
    public void save(Matricula matricula);

    public List<Matricula> findAll();

    public void delete(Matricula matricula);
    
    public Matricula findById(Long id);
    
}
