package espe.edu.matriculacion.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Matricula implements Serializable {

    private Long Id;

    private Curso curso = new Curso();

    private Persona persona = new Persona();

    private Cuenta cuenta = new Cuenta();

    private Date fecha_creacion = new Date(System.currentTimeMillis());

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public Matricula() {
        super();
    }

    public Matricula(Long id, Curso curso, Persona persona, Date fecha_creacion) {
        super();
        Id = id;
        this.curso = curso;
        this.persona = persona;
        this.fecha_creacion = fecha_creacion;
    }

    public Matricula(Curso curso, Persona persona) {
        this.curso = curso;
        this.persona = persona;
    }



    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
