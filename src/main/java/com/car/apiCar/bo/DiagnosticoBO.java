package com.car.apiCar.bo;

import com.car.apiCar.model.Diagnostico;
import com.car.apiCar.model.Usuario;
import com.car.apiCar.dao.DiagnosticoDAO;

import java.util.List;

public class DiagnosticoBO {

    private DiagnosticoDAO diagnosticoDAO;

    public DiagnosticoBO() {
        this.diagnosticoDAO = new DiagnosticoDAO();
    }

    public List<Diagnostico> listarDiagnosticosPorUsuario() {
        return diagnosticoDAO.listarDiagnosticosPorUsuario();
    }

//    public Diagnostico obterDiagnosticoRecente() {
//        return diagnosticoDAO.mostrarDiagnosticoRecente();
//    }
//
//    public boolean excluirDiagnostico(int diagnosticoId) {
//        return diagnosticoDAO.excluirDiagnosticoPorUsuario(diagnosticoId);
//    }
}
