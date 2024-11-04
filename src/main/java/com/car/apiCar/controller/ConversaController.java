package com.car.apiCar.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import com.car.apiCar.bo.ConversaBO;
import com.car.apiCar.model.Conversa;

import java.util.List;

@Path("/conversas")
public class ConversaController {

    private ConversaBO conversaBO;

    // Construtor para injeção de dependência
    public ConversaController() {
        this.conversaBO = new ConversaBO();
    }

    // Criar conversa
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarConversa() {
        boolean criada = conversaBO.criarConversa();
        if (criada) {
            return Response.status(Response.Status.CREATED).entity("Conversa criada com sucesso.").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao criar conversa.").build();
    }

    // Listar conversas do usuário
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarConversas() {
        List<Conversa> conversas = conversaBO.listarConversasPorUsuario();
        if (conversas != null && !conversas.isEmpty()) {
            return Response.ok(conversas).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Nenhuma conversa encontrada para o usuário.").build();
    }

    // Finalizar conversa
//    @PUT
//    @Path("/{id}/finalizar")
//    @Produces(MediaType.TEXT_PLAIN)
//    public Response finalizarConversa(@PathParam("id") int id) {
//        boolean finalizada = conversaBO.finalizarConversa(id);
//        if (finalizada) {
//            return Response.ok("Conversa finalizada com sucesso.").build();
//        }
//        return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao finalizar conversa.").build();
//    }
}
