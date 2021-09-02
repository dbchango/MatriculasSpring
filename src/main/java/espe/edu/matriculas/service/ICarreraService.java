package espe.edu.matriculas.service;

import java.util.List;

import espe.edu.matriculas.entities.Carrera;
import espe.edu.matriculas.entities.Materia;

public interface ICarreraService {
	public void save(Carrera carrera);

    public List<Carrera> findAll();

    public void delete(Carrera carrera);

    public List<Materia> findCarreraMaterias(long id);

}
