package espe.edu.matriculas.repository;

import espe.edu.matriculas.entities.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

import espe.edu.matriculas.entities.Curso;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface ICursoRep extends JpaRepository<Curso, Long> {
    Curso findByNrc(String nrc);

    boolean existsByNombre(String nombre);

    boolean existsByNrc(String nrc);

}
