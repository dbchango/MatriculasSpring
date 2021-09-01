package espe.edu.matriculas.repository;

import espe.edu.matriculas.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRep extends JpaRepository<Persona, Long> {

}
