package espe.edu.matriculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import espe.edu.matriculas.entities.Matricula;

public interface IMatriculaRep extends JpaRepository<Matricula, Long>{

}
