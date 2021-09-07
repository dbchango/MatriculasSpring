package espe.edu.matriculacion.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Curso implements Serializable{

	private Long Id;

	private String nombre;

	private String nrc;

	private String descripcion;

	private Date fecha_creacion;

	private Materia materia;

	private List<Matricula> matriculas;

	public Curso() {
		super();
	}

	public Curso(String nombre, String nrc, String descripcion, Date fecha_creacion, Materia materia) {
		this.nombre = nombre;
		this.nrc = nrc;
		this.descripcion = descripcion;
		this.fecha_creacion = fecha_creacion;
		this.materia = materia;
	}

	public Curso(Long id, String nombre, String nrc,
                 String descripcion, Date fecha_creacion, Materia materia) {
		super();
		Id = id;
		this.nombre = nombre;
		this.nrc = nrc;
		this.descripcion = descripcion;
		this.fecha_creacion = fecha_creacion;
		this.materia = materia;
	}

	public Curso(String nombre, String nrc, Materia materia) {
		this.nombre = nombre;
		this.nrc = nrc;
		this.materia = materia;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNrc() {
		return nrc;
	}

	public void setNrc(String nrc) {
		this.nrc = nrc;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
}
