package espe.edu.matriculas.entities;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "matriculas")
public class Matricula implements Serializable{
	
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_curso", nullable = false)
	private Curso curso;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_persona", nullable = false)
	private Persona persona;

	@OneToMany(
            cascade = CascadeType.ALL, mappedBy = "matricula"
    )
    private List<Cuenta> cuentas;
    
    
	@CreatedDate
	@Column(name = "fecha_creacion")
	private Date fecha_creacion;

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

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

}