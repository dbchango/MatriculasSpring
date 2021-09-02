package espe.edu.matriculas.service;

import espe.edu.matriculas.entities.Carrera;
import espe.edu.matriculas.entities.Materia;
import espe.edu.matriculas.repository.ICarreraRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarreraService implements ICarreraService {
	@Autowired
	private ICarreraRep dao;
	
	 @Override
	 public void save(Carrera carrera) {
		 dao.save(carrera);
	 }

	 @Override
	 public List<Carrera> findAll() {
		 return dao.findAll();
	 }
	 @Override
	 public void delete(Carrera carrera) {
		 dao.delete(carrera);
	 }
	 
	 @Override
	 public List<Materia> findCarreraMaterias(long id){
		 return dao.findById(id).get().getMaterias();
	 }
	 
}
