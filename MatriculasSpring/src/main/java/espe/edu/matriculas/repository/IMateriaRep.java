package espe.edu.matriculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import espe.edu.matriculas.entities.Materia;

@Repository
public interface IMateriaRep extends JpaRepository<Materia, Long>{
	

}
