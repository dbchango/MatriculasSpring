package espe.edu.matriculas.service;

import espe.edu.matriculas.entities.Cuenta;
import espe.edu.matriculas.entities.Persona;

import java.util.List;

public interface IPersonaService {
    public void save(Persona persona);

    public List<Persona> findAll();

    public void delete(Persona persona);

    public List<Cuenta> findPersonaCuentas(long id);
}
