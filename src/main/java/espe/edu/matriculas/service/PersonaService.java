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
    public void delete(Persona persona) {
        dao.delete(persona);
    }

    @Override
    public List<Cuenta> findPersonaCuentas(long id){
        return dao.findById(id).get().getCuentas();
    }
}
