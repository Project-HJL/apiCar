package com.car.apiCar.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import com.car.apiCar.bo.MensagemBO;
import com.car.apiCar.model.Conversa;
import com.car.apiCar.model.Mensagem;
import java.util.List;

@Path("/mensagens")
public class MensagemController {

    private MensagemBO mensagemBO;

    // Construtor para injeção de dependência
    public MensagemController() {
        this.mensagemBO = new MensagemBO();
    }

    // Criar Mensagem
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response inserirMensagem(Mensagem mensagem, @QueryParam("conversaId") int conversaId) {
        Conversa conversa = new Conversa(conversaId); // Instancia uma conversa com base no ID
        boolean inserida = mensagemBO.inserirMensagem(mensagem.getConteudo(), mensagem.getTipo(), mensagem.getDataHora(), conversa);

        if (inserida) {
            return Response.status(Response.Status.CREATED).entity("Mensagem inserida com sucesso.").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao inserir mensagem.").build();
    }

    // Listar Mensagens por Conversa
    @GET
    @Path("/{conversaId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarMensagens(@PathParam("conversaId") int conversaId) {
        Conversa conversa = new Conversa(conversaId);
        List<Mensagem> mensagens = mensagemBO.listarMensagensPorConversa(conversa);

        if (mensagens != null && !mensagens.isEmpty()) {
            return Response.ok(mensagens).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Nenhuma mensagem encontrada para esta conversa.").build();
    }
}
