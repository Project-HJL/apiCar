package com.car.apiCar.model;

import java.util.Date;

public class Diagnostico {
    private int id;
    private String relatorio;
    private Date dataHora;
    private Usuario usuario;
    private Veiculo veiculo;

    
    
    public Diagnostico() {
		super();
	}

	//Construtor completo
    public Diagnostico(int id, String relatorio, Date dataHora, Usuario usuario, Veiculo veiculo) {
        this.id = id;
        this.relatorio = relatorio;
        this.dataHora = dataHora;
        this.usuario = usuario;
        this.veiculo = veiculo;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(String relatorio) {
        this.relatorio = relatorio;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}