package espe.edu.matriculas.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.Constraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Table(name = "personas",
uniqueConstraints = {
        @UniqueConstraint(columnNames = "cedula")
})
@Entity

public class Persona implements Serializable {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank
    @Column(name = "cedula")
    @Size(max = 10)
    private String cedula;

    @Column(name = "edad")
    private int edad;

    @NotBlank
    @Column(name = "nombres")
    @Size(max = 100)
    private String nombres;

    @NotBlank
    @Column(name = "apellidos")
    @Size(max = 100)
    private String apellidos;

    @Email
    @Column(name = "correo")
    @Size(max = 100)
    private String correo;

    @Column(name = "direccion")
    @Size(max = 500)
    private String direccion;

    @OneToMany(
            cascade = CascadeType.ALL, mappedBy = "persona"
    )
    private List<Matricula> matriculas;

    public Persona() {
    }

    public Persona(long id, int edad, String nombres, String cedula, String apellidos, String correo, String direccion) {
        Id = id;
        this.edad = edad;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.direccion = direccion;
    }

    public Persona(String cedula, int edad, String nombres, String apellidos, String correo, String direccion) {
        this.cedula = cedula;
        this.edad = edad;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.direccion = direccion;
    }


    public Persona(String cedula, String nombres, String apellidos) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getId() {
        return Id;
    }

    @JsonManagedReference(value = "persona_matriculas")
    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}
