package com.car.apiCar.model;

public class DiagnosticoProblema {
    private Diagnostico diagnostico;
    private Problemas problemas;

    public DiagnosticoProblema(Diagnostico diagnostico, Problemas problemas) {
        this.diagnostico = diagnostico;
        this.problemas = problemas;
    }

    
    
    public DiagnosticoProblema() {
		super();
	}



	// Getters and Setters

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Problemas getProblemas() {
        return problemas;
    }

    public void setProblemas(Problemas problemas) {
        this.problemas = problemas;
    }
}
