package com.car.apiCar.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import com.car.apiCar.bo.ModeloBO;
import com.car.apiCar.model.Modelo;

import java.util.List;


@Path("/modelos")
public class ModeloController {

    private ModeloBO modeloBO;

    // Construtor para injeção de dependência
    public ModeloController() {
        this.modeloBO = new ModeloBO();
    }

    // Cadastrar Modelo
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrarModelo(Modelo modelo) {
        boolean cadastrado = modeloBO.cadastrarModelo(modelo.getMarca(), modelo.getNomeModelo(), modelo.getAno(), modelo.getVersao());

        if (cadastrado) {
            return Response.status(Response.Status.CREATED).entity("Modelo cadastrado com sucesso.").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao cadastrar o modelo.").build();
    }

    // Listar Modelos
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarModelos() {
        List<Modelo> modelos = modeloBO.listarTodosModelos();
        if (modelos != null && !modelos.isEmpty()) {
            return Response.ok(modelos).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Nenhum modelo encontrado.").build();
        
    }
    
}
