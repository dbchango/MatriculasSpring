package espe.edu.matriculas.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "cursos")
public class Curso implements Serializable{
	@Id
	@Column(name = "Id")
	private Long Id;
	
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

	@NotBlank
	@Column(name = "nombre")
	@Size(max = 50)
	private String nombre;
	
	@NotBlank
	@Column(name = "nrc")
	@Size(max = 5)
	private String nrc;
	
	@NotBlank
	@Column(name = "descripcion")
	@Size(max = 255)
	private String descripcion;
	
	public Curso() {
		super();
	}

	public Curso(Long id, @NotBlank @Size(max = 50) String nombre, @NotBlank @Size(max = 5) String nrc,
			@NotBlank @Size(max = 255) String descripcion, Date fecha_creacion, Materia materia) {
		super();
		Id = id;
		this.nombre = nombre;
		this.nrc = nrc;
		this.descripcion = descripcion;
		this.fecha_creacion = fecha_creacion;
		this.materia = materia;
	}

	@CreatedDate
	@Column(name = "fecha_creacion")
	private Date fecha_creacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_materia", nullable = false)
	private Materia materia;
}
