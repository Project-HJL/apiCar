package com.car.apiCar.model;

public class Problemas {
    private int id;
    private String dscriProblema;
    private double precoSolucao;
    private String solucao;

    public Problemas(int id, String dscriProblema, double precoSolucao, String solucao) {
        this.id = id;
        this.dscriProblema = dscriProblema;
        this.precoSolucao = precoSolucao;
        this.solucao = solucao;
    }
    
    

    public Problemas() {
		super();
	}



	// Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDscriProblema() {
        return dscriProblema;
    }

    public void setDscriProblema(String dscriProblema) {
        this.dscriProblema = dscriProblema;
    }

    public double getPrecoSolucao() {
        return precoSolucao;
    }

    public void setPrecoSolucao(double precoSolucao) {
        this.precoSolucao = precoSolucao;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }
}