package com.car.apiCar.model;

import javax.xml.bind.annotation.XmlRootElement;
//
@XmlRootElement
public class Usuario {
	private int id;
	private String nome;
	private String email;
	private String senha;
	
	public Usuario() {
		super();
	}

	//Construtor Completo
	public Usuario(int id, String nome, String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
	//Construtor para cadastro
	public Usuario(String nome, String email, String senha){
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	//Construtor para login
	public Usuario(String email, String senha){
		this.email = email;
		this.senha = senha;
	}

	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
