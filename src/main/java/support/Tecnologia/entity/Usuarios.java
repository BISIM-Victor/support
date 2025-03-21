package support.Tecnologia.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String usuario;
    private int idPerfil;
    private String nomUsuario;
    private String apUsuario;
    private String amUsuario;
    private String extencion;
    private String oficina;
    private String secret;
    private int estatus;
    private OffsetDateTime lastCon;
    private OffsetDateTime  lastSecretChange;
    private int secretChange;
    private int secretPolicy;

}
