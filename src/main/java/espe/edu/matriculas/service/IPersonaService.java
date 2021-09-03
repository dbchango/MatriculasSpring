package espe.edu.matriculas.service;

import espe.edu.matriculas.entities.Cuenta;
import espe.edu.matriculas.entities.Persona;

import java.util.List;

public interface IPersonaService {
    public void save(Persona persona);

    public List<Persona> findAll();

    public void delete(Long id);

    public List<Cuenta> findCuentas(long id);

    public boolean existsById(Long id);

    public Persona findById(Long id);

    public List<Cuenta> findCuentasPendientes(Long id);
}
