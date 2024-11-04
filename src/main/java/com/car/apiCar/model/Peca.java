package com.car.apiCar.model;

public class Peca {
	private int id;
	private String dscriPeca;
	private String nome;
	private double preco;
	
	

	public Peca() {
		super();
	}

	public Peca(int id, String dscriPeca, String nome, double preco) {
		this.id = id;
		this.dscriPeca = dscriPeca;
		this.nome = nome;
		this.preco = preco;
	}

	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDscriPeca() {
		return dscriPeca;
	}

	public void setDscriPeca(String dscriPeca) {
		this.dscriPeca = dscriPeca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}
