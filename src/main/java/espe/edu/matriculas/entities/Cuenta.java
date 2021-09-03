package espe.edu.matriculas.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cuentas")
public class Cuenta implements Serializable {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "estado")
    private boolean estado = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_matricula", nullable = false)
    private Matricula matricula;

    public Cuenta(Persona persona, Matricula matricula) {
        this.persona = persona;
        this.matricula = matricula;
    }

    public Cuenta() {
    }

    public Cuenta(boolean estado, Persona persona, Matricula matricula) {
        this.estado = estado;
        this.persona = persona;
        this.matricula = matricula;
    }

    public Cuenta(Long id, boolean estado, Persona persona, Matricula matricula) {
        Id = id;
        this.estado = estado;
        this.persona = persona;
        this.matricula = matricula;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }


}
