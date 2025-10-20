package quarkus.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tb_usuarios")
public class Users extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    public String nomedousuario;
    public String email;
    public String cpf;
    public String telefone;
    public String endereco;


}
