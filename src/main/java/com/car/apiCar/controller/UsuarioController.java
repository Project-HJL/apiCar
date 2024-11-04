package com.car.apiCar.controller;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import com.car.apiCar.bo.UsuarioBO;
import com.car.apiCar.model.Usuario;

@Path("/usuario")
public class UsuarioController {

    private UsuarioBO usuarioBO;

    public UsuarioController() {
        this.usuarioBO = new UsuarioBO();
    }

    // Cadastrar usuário
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrarUsuario(Usuario usuario, @Context UriInfo uriInfo) {
        Usuario novoUsuario = usuarioBO.cadastrarUsuario(usuario.getNome(), usuario.getEmail(), usuario.getSenha());
        if (novoUsuario != null) {
            UriBuilder builder = uriInfo.getAbsolutePathBuilder();
            builder.path(Integer.toString(novoUsuario.getId()));
            return Response.created(builder.build()).entity(novoUsuario).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao cadastrar o usuário.").build();
    }

 // Login de usuário
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUsuario(Usuario usuario, @Context UriInfo uriInfo) {
        Usuario usuarioLogado = usuarioBO.loginUsuario(usuario.getEmail(), usuario.getSenha());
        if (usuarioLogado != null) {
            return Response.ok(usuarioLogado).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).entity("Erro ao realizar login.").build();
    }

    // Editar senha do usuário
    @PUT
    @Path("/editar-senha")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response editarSenhaUsuario(@QueryParam("novaSenha") String novaSenha) {
        boolean resultado = usuarioBO.editarSenhaUsuario(novaSenha);
        if (resultado) {
            return Response.ok("Senha alterada com sucesso.").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao alterar a senha.").build();
    }

    // Excluir usuário
    @DELETE
    @Path("/excluir")
    @Produces(MediaType.TEXT_PLAIN)
    public Response excluirUsuario() {
        boolean resultado = usuarioBO.excluirUsuario();
        if (resultado) {
            return Response.ok("Usuário excluído com sucesso.").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao excluir o usuário.").build();
    }


}


