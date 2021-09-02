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

	public long getId_carrera() {
		return Id_carrera;
	}

	public void setId_carrera(long id_carrera) {
		Id_carrera = id_carrera;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera", nullable = false)
	
	@OneToMany(
            cascade = CascadeType.ALL, mappedBy = "carrera"
    )
    private List<Curso> cursos;
	

	@NotBlank
    @Column(name = "nombre")
    @Size(max = 50)
    private String nombre;

    @Id
    @Column(name = "Id_carrera")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id_carrera;
    
    @CreatedDate
	@Column(name = "fecha_creacion")
	private Date fecha_creacion;

	public Materia() {
		super();
	}

	public Materia(long id, @NotBlank @Size(max = 50) String nombre, long id_carrera, Date fecha_creacion) {
		super();
		Id = id;
		this.nombre = nombre;
		Id_carrera = id_carrera;
		this.fecha_creacion = fecha_creacion;
	}
    

	

}
