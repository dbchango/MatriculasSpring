package espe.edu.matriculas.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "cuentas")
public class Cuenta implements Serializable {
    @Id
    @Column(name = "Id")
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

}
