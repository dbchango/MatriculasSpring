package espe.edu.matriculas.repository;

import espe.edu.matriculas.entities.ERole;
import espe.edu.matriculas.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IRole extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
