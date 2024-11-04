package com.car.apiCar.model;


public class Modelo {
    private int id;
    private String marca;
    private String nomeModelo;
    private int ano;
    private String versao;
    
    

    public Modelo() {
		super();
	}
	//Construtor Completo
    public Modelo(int id, String marca, String nomeModelo, int ano, String versao) {
        this.id = id;
        this.marca = marca;
        this.nomeModelo = nomeModelo;
        this.ano = ano;
        this.versao = versao;
    }
    //Construtor De Cadastro
    public Modelo(String marca, String nomeModelo, int ano, String versao) {
        this.marca = marca;
        this.nomeModelo = nomeModelo;
        this.ano = ano;
        this.versao = versao;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }
}