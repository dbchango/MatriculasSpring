package espe.edu.matriculas.service;

import espe.edu.matriculas.entities.Cuenta;
import espe.edu.matriculas.entities.Matricula;
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
        dao.saveAndFlush(persona);
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
    public List<Matricula> findMatriculas(long id){
        return dao.findById(id).get().getMatriculas();

    }

    @Override
    public boolean existsById(Long id) {
        return dao.existsById(id);
    }

    @Override
    public boolean existsByCedula(String ci) {
        return dao.existsByCedula(ci);
    }

    @Override
    public Persona findById(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public Persona findByCedula(String ci) {
        return dao.findByCedula(ci);
    }

}
