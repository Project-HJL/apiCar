package com.car.apiCar.model;

public class Conversa {
	private int id;
	private char status;
	private Usuario usuario;
	
	public Conversa() {
		super();
	}

	public Conversa(int id, Character status, Usuario usuario) {
		this.id = id;
		this.status = status;
		this.usuario = usuario;
	}
	public Conversa(int id){
		this.id = id;
	}


	public Conversa(Character status) {
		this.status = status;
	}

	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}