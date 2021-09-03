package espe.edu.matriculas.service;

import java.util.List;

import espe.edu.matriculas.entities.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import espe.edu.matriculas.entities.Materia;
import espe.edu.matriculas.repository.IMateriaRep;

@Service
public class MateriaService implements IMateriaService{

	 	@Autowired
		private IMateriaRep dao;

		@Override
		public void save(Materia materia) {
			dao.saveAndFlush(materia);
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
		public List<Curso> findMateriaCursos(long id){
			return dao.findById(id).get().getCursos();
		}
}
