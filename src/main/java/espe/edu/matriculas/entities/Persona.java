package espe.edu.matriculas.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Table(name = "personas")
@Entity
public class Persona implements Serializable {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

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
    private List<Cuenta> cuentas;

    public Persona() {
    }

    public Persona(long id, int edad, String nombres, String apellidos, String correo, String direccion) {
        Id = id;
        this.edad = edad;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.direccion = direccion;
    }

    public long getId() {
        return Id;
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

    public void setId(long id) {
        Id = id;
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

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

}
