package com.car.apiCar.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import com.car.apiCar.bo.VeiculoBO;
import com.car.apiCar.model.Modelo;
import com.car.apiCar.model.Veiculo;

import java.util.List;

@Path("/veiculos")
public class VeiculoController {

    private VeiculoBO veiculoBO;

    // Construtor para injeção de dependência
    public VeiculoController() {
        this.veiculoBO = new VeiculoBO();
    }

    // Cadastrar Veículo
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrarVeiculo(Modelo modelo) {
        boolean cadastrado = veiculoBO.cadastrarVeiculo(modelo);

        if (cadastrado) {
            return Response.status(Response.Status.CREATED).entity("Veículo cadastrado com sucesso.").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao cadastrar o veículo.").build();
    }

    // Listar Veículos
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarVeiculos() {
        List<Veiculo> veiculos = veiculoBO.listarVeiculosPorUsuario();

        if (veiculos != null && !veiculos.isEmpty()) {
            return Response.ok(veiculos).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Nenhum veículo encontrado.").build();
    }

    // Excluir Veículo
//    @DELETE
//    @Path("/{idVeiculo}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response excluirVeiculo(@PathParam("idVeiculo") int idVeiculo) {
//        boolean excluido = veiculoBO.excluirVeiculo(idVeiculo);
//
//        if (excluido) {
//            return Response.ok("Veículo excluído com sucesso.").build();
//        }
//        return Response.status(Response.Status.NOT_FOUND).entity("Veículo não encontrado.").build();
//    }
}
