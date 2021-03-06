package espe.edu.matriculas.service;

import espe.edu.matriculas.entities.Cuenta;
import espe.edu.matriculas.entities.Matricula;
import espe.edu.matriculas.entities.Persona;

import java.util.List;

public interface IPersonaService {
    public void save(Persona persona);

    public List<Persona> findAll();

    public void delete(Long id);

    public List<Matricula> findMatriculas(long id);

    public boolean existsById(Long id);

    public boolean existsByCedula(String ci);

    public Persona findById(Long id);

    public Persona findByCedula(String ci);

}
