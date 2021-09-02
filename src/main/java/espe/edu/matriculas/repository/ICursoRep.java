package espe.edu.matriculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import espe.edu.matriculas.entities.Curso;

public interface ICursoRep extends JpaRepository<Curso, Long> {

}
