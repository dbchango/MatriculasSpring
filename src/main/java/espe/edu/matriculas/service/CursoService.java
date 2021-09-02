package espe.edu.matriculas.service;

import espe.edu.matriculas.entities.Curso;
import espe.edu.matriculas.repository.ICursoRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService implements ICursoService{
	
    @Autowired
    private ICursoRep dao;
    
    @Override
    public void save(Curso curso) {
        dao.save(curso);
    }

    @Override
    public List<Curso> findAll() {
        return dao.findAll();
    }

    @Override
    public void delete(Curso curso) {
        dao.delete(curso);
    }

	@Override
	public Curso findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}
    
}
