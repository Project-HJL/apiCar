package com.car.apiCar.model;

public class Veiculo {
	private int id;
	private Usuario usuario;
	private Modelo modelo;

	//Construtor completo
	public Veiculo(int id, Usuario usuario, Modelo modelo) {
		this.id = id;
		this.usuario = usuario;
		this.modelo = modelo;
	}

	//Construtor listar
	public Veiculo(int id, Modelo modelo) {
		this.id = id;
		this.modelo = modelo;
	}

	public Veiculo() {
		super();
	}

	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
}