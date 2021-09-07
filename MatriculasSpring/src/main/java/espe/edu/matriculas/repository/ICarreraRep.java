package espe.edu.matriculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import espe.edu.matriculas.entities.Carrera;

@Repository
public interface ICarreraRep extends JpaRepository<Carrera, Long> {

}
