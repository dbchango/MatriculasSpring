package espe.edu.matriculas.entities;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;


@Table(name = "materias")
@Entity
public class Materia {

	@Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

	@NotBlank
	@Column(name = "nombre")
	@Size(max = 50)
	private String nombre;

	@OneToMany(
			cascade = CascadeType.ALL, mappedBy = "materia"
	)
	private List<Curso> cursos;

	@CreatedDate
	@Column(name = "fecha_creacion")
	private Date fecha_creacion;

	@ManyToOne(
			fetch = FetchType.LAZY
	)
	@JoinColumn(name = "id_carrera", nullable = false)
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
}
