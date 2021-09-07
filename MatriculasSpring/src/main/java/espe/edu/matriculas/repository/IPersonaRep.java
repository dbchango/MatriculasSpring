package espe.edu.matriculas.repository;

import espe.edu.matriculas.entities.Cuenta;
import espe.edu.matriculas.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonaRep extends JpaRepository<Persona, Long> {

    boolean existsById(Long id);

    boolean existsByCedula(String ci);

    Persona findByCedula(String ci);

    
}
