package espe.edu.matriculas.service;

import espe.edu.matriculas.entities.Cuenta;
import espe.edu.matriculas.entities.Persona;
import espe.edu.matriculas.repository.IPersonaRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService {
    @Autowired
    private IPersonaRep dao;

    @Override
    public void save(Persona persona) {
        dao.save(persona);
    }

    @Override
    public List<Persona> findAll() {
        return dao.findAll();
    }

    @Override
    public void delete(Long id) {
        dao.deleteById(id);
    }

    @Override
    public List<Cuenta> findCuentas(long id){
        return dao.findById(id).get().getCuentas();
    }

    @Override
    public boolean existsById(Long id) {
        return dao.existsById(id);
    }

    @Override
    public Persona findById(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public List<Cuenta> findCuentasPendientes(Long id) {
        return null;
    }
}
