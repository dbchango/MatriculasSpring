package espe.edu.matriculacion.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;


public class Materia implements Serializable {


    private long Id;

	private String nombre;

	private List<Curso> cursos;

	private Date fecha_creacion;

	private Carrera carrera;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Materia() {
	}

	public Materia(long id, String nombre, List<Curso> cursos, Date fecha_creacion, Carrera carrera) {
		Id = id;
		this.nombre = nombre;
		this.cursos = cursos;
		this.fecha_creacion = fecha_creacion;
		this.carrera = carrera;
	}

	public Materia(String nombre, List<Curso> cursos, Date fecha_creacion, Carrera carrera) {
		this.nombre = nombre;
		this.cursos = cursos;
		this.fecha_creacion = fecha_creacion;
		this.carrera = carrera;
	}

	public Materia(String nombre, Date fecha_creacion, Carrera carrera) {
		this.nombre = nombre;
		this.fecha_creacion = fecha_creacion;
		this.carrera = carrera;
	}


}
