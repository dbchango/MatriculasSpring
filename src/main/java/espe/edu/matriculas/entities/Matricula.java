package espe.edu.matriculas.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
/*
	@OneToMany(
            cascade = CascadeType.ALL, mappedBy = "matricula"
    )*/
	@OneToOne(
			mappedBy = "matricula", cascade = CascadeType.ALL
	)
    private Cuenta cuenta;

	@Column(name = "fecha_creacion")
	private Date fecha_creacion = new Date(System.currentTimeMillis());;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	@JsonBackReference(value = "curso_matriculas")
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@JsonBackReference(value = "persona_matriculas")
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
/*
	public Cuenta getCuentas() {
		return cuenta;
	}

	public void setCuentas(Cuenta cuentas) {
		this.cuenta = cuentas;
	}
*/
	//@JsonBackReference(value = "cuenta_matricula")
	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
}