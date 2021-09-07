package espe.edu.matriculacion.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

public class Carrera implements Serializable {

    private long Id;

    private String nombre;

    private String descripcion;

    private List<Materia> materias;
    
    public Carrera() {
    }

    public Carrera(String nombre, String descripcion, List<Materia> materias) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.materias = materias;
    }

    public Carrera(long id, String nombre, long id_departamento, String descripcion) {
        Id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        
    }

    public long getId() {
        return Id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId(long id) {
        Id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
    
	

}