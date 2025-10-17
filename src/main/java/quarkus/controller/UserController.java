package quarkus.controller;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import quarkus.domain.Users;
import quarkus.service.UserService;

import java.util.UUID;

@Path("/usuarios")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Path("/listar")
    @Transactional
    public Response listarTodosOsUsuarios (@QueryParam("pagina") @DefaultValue("0") Integer pagina, @QueryParam("quantidade") @DefaultValue("10") Integer quantidade){
        var users = userService.listarTodosOsUsuarios(pagina,quantidade);
        return Response.ok(users).build();
    }

    @GET
    @Path("/{id}")
    @Transactional
    public Response listarUsuarioPorId (@PathParam("id")UUID uuid){
        return Response.ok(userService.listarUsuarioPorId(uuid)).build();
    }

    @PUT
    @Path("/atualizar/{id}")
    @Transactional
    public Response atualizarUsuarioPorId (@PathParam("id") UUID uuid, Users users) {
        return Response.ok(userService.atualizarUsuarioPorId(uuid, users)).build();
    }

    @POST
    @Path("/criar")
    @Transactional
    public Response criarUsuario (Users users) {
        return Response.ok(userService.criarUsuario(users)).build();
    }

    @DELETE
    @Path("/deletar/{id}")
    @Transactional
    public Response deletarUsuarioPorId (@PathParam("id") UUID uuid) {
        userService.deletarUsuarioPorId(uuid);
        return Response.ok("Usuário deletado").build();
    }
}
