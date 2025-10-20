package quarkus.service;

import jakarta.enterprise.context.ApplicationScoped;
import quarkus.domain.Users;
import quarkus.exception.UserNotFoundException;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserService {

    public Users criarUsuario(Users users){
        Users.persist(users);
        return users;
    }

    public List<Users> listarTodosOsUsuarios(Integer pagina, Integer quantidade) {
        return Users.findAll().page(pagina, quantidade).list();
    }

    public Users listarUsuarioPorId(UUID uuid){
        return (Users) Users.findByIdOptional(uuid).orElseThrow(UserNotFoundException::new);
    }

    public Users atualizarUsuarioPorId(UUID uuid, Users users){
        var user = listarUsuarioPorId(uuid);
        user.nomedousuario = users.nomedousuario;
        user.email = users.email;
        user.cpf = users.cpf;
        user.telefone = users.telefone;
        user.endereco = users.endereco;
        Users.persist(user);
        return user;
    }

    public void deletarUsuarioPorId(UUID uuid){
        var user = listarUsuarioPorId(uuid);
        Users.deleteById(uuid);
    }
}
