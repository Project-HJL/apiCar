package com.car.apiCar.model;

import java.util.Date;

public class Mensagem {
	private int id;
	private String conteudo;
	private String tipo;
	private Date dataHora;
	private Conversa conversa;
	
	

	public Mensagem() {
		super();
	}
	public Mensagem(int id, String conteudo, String tipo, Date dataHora, Conversa conversa) {
		this.id = id;
		this.conteudo = conteudo;
		this.tipo = tipo;
		this.dataHora = dataHora;
		this.conversa = conversa;
	}
	public Mensagem(String conteudo, String tipo, Date dataHora, Conversa conversa) {
		this.conteudo = conteudo;
		this.tipo = tipo;
		this.dataHora = dataHora;
		this.conversa = conversa;
	}
	
	public Mensagem(String conteudo, String tipo, Date dataHora ) {
		this.conteudo = conteudo;
		this.tipo = tipo;
		this.dataHora = dataHora;
	}

	public Mensagem(Conversa conversa){
		this.conversa = conversa;
	}

	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public Conversa getConversa() {
		return conversa;
	}

	public void setConversa(Conversa conversa) {
		this.conversa = conversa;
	}
}