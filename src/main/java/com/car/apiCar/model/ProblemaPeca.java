package com.car.apiCar.model;

public class ProblemaPeca {
    private Peca peca;
    private Problemas problemas;

    public ProblemaPeca(Peca peca, Problemas problemas) {
        this.peca = peca;
        this.problemas = problemas;
    }

    
    
    public ProblemaPeca() {
		super();
	}



	// Getters and Setters

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    public Problemas getProblemas() {
        return problemas;
    }

    public void setProblemas(Problemas problemas) {
        this.problemas = problemas;
    }
}