package espe.edu.matriculas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import espe.edu.matriculas.entities.Cuenta;
import espe.edu.matriculas.entities.Materia;
import espe.edu.matriculas.repository.IMateriaRep;
import espe.edu.matriculas.repository.IPersonaRep;

@Service
public class MateriaService implements IMateriaService{

	 @Autowired
	    private IMateriaRep dao;


	    @Override
	    public void save(Materia materia) {
	        dao.save(materia);
	    }

	    @Override
	    public List<Materia> findAll() {
	        return dao.findAll();
	    }

	    @Override
	    public void delete(Materia materia) {
	        dao.delete(materia);
	    }

	    @Override
	    public List<Materia> findMateriaCursos(long id){
	        return dao.findById(id).get().getCursos();
	    }
}
