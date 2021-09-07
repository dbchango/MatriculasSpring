package espe.edu.matriculacion.repository;

import espe.edu.matriculacion.entities.ERole;
import espe.edu.matriculacion.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRep extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
