package espe.edu.matriculas.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import espe.edu.matriculas.entities.Cuenta;
import espe.edu.matriculas.entities.Matricula;
import espe.edu.matriculas.repository.IMatriculaRep;
import org.springframework.stereotype.Service;


@Service
public class MatriculaService  implements IMatriculaService{
	
    @Autowired
    private IMatriculaRep dao;
    
    @Override
    public void save(Matricula matricula) {
        dao.save(matricula);
    }

    @Override
    public List<Matricula> findAll() {
        return dao.findAll();
    }

    @Override
    public void delete(Matricula matricula) {
        dao.delete(matricula);
    }

	@Override
	public Matricula findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}
	
}
