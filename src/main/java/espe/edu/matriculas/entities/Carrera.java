package espe.edu.matriculas.entities;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.List;

@Table(name = "carreras")
@Entity
public class Carrera implements Serializable {
	
	@Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @NotBlank
    @Column(name = "nombre")
    @Size(max = 50)
    private String nombre;

    @Id
    @Column(name = "Id_departamento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id_departamento;
    
    @NotBlank
    @Column(name = "descripcion")
    @Size(max = 200)
    private String descripcion;
    


    @OneToMany(
            cascade = CascadeType.ALL, mappedBy = "carrera"
    )
    private List<Materia> materias;
    
    public Carrera() {
    }

    public Carrera(long id, String nombre, long id_departamento, String descripcion) {
        Id = id;
        this.nombre = nombre;
        Id_departamento = id_departamento;
        this.descripcion = descripcion;
        
    }

    public long getId() {
        return Id;
    }

    public String getNombre() {
        return nombre;
    }
    
    public long getId_departamento() {
        return Id_departamento;
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
    
    public void setId_departamento(long id_departamento) {
    	Id_departamento = id_departamento;
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