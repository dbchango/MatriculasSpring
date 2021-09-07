package espe.edu.matriculas.service;

import java.util.List;

import espe.edu.matriculas.entities.Curso;
import espe.edu.matriculas.entities.Materia;

public interface IMateriaService {
	public void save(Materia materia);
	
	public List<Materia> findAll();
	
	public void delete(Materia materia);
	
	public List<Curso> findMateriaCursos(long id);

}
