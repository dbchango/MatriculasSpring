package espe.edu.matriculas.service;

import espe.edu.matriculas.entities.Curso;

import java.util.List;

public interface ICursoService {
	
    public void save(Curso curso);

    public List<Curso> findAll();

    public void delete(Curso curso);
    
    public Curso findById(Long id);
}
