package espe.edu.matriculacion.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import espe.edu.matriculacion.entities.Persona;
import espe.edu.matriculacion.repository.PersonaRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
@Service
public class PersonaService implements IPersonaService{
    @Autowired
    PersonaRep personaRep;

    @Override
    public Persona findByCedula(String ci) throws ExecutionException, InterruptedException, JsonProcessingException {
        return personaRep.findByCedula(ci);
    }

    @Override
    public Boolean existsByCedula(String ci) throws ExecutionException, InterruptedException, JsonProcessingException {
        return personaRep.existsByCedula(ci);
    }
}
