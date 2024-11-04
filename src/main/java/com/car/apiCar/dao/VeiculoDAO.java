package com.car.apiCar.dao;

import com.car.apiCar.model.*;
import com.car.apiCar.config.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {

    public boolean cadastrarVeiculo(Modelo modelo) {
        Usuario usuario = UsuarioSession.getInstance().getUsuario(); // Obtendo o usuário da sessão

        String sql = "INSERT INTO veiculo (fk_Usuario_id, fk_Modelo_id) VALUES (?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, usuario.getId());
            ps.setInt(2, modelo.getId());
            System.out.println("Veículo cadastrado");
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Veiculo> listarVeiculosPorUsuario() {
        Usuario usuario = UsuarioSession.getInstance().getUsuario(); // Obtendo o usuário da sessão
        String sql = "SELECT v.id AS veiculo_id, v.fk_Modelo_id, m.marca, m.nomeModelo, m.ano, m.versao " +
                "FROM veiculo v JOIN modelo m ON v.fk_Modelo_id = m.id WHERE v.fk_Usuario_id = ?";
        List<Veiculo> veiculos = new ArrayList<>();

        try (Connection conn = Conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, usuario.getId());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Modelo modelo = new Modelo(
                            rs.getInt("fk_Modelo_id"),
                            rs.getString("marca"),
                            rs.getString("nomeModelo"),
                            rs.getInt("ano"),
                            rs.getString("versao")
                    );
                    Veiculo veiculo = new Veiculo(
                            rs.getInt("veiculo_id"), modelo
                    );
                    veiculos.add(veiculo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veiculos;
    }

    public boolean excluirVeiculo(int veiculoId) {
        String sql = "DELETE FROM veiculo WHERE id = ?";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            conn.setAutoCommit(true);
            ps.setInt(1, veiculoId);
            
            int rowsAffected = ps.executeUpdate();
            System.out.println("Veículo excluído");
            
            return rowsAffected > 0; // Retorna true se uma linha foi excluída
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            Conexao.fecharConexao(); // Fecha a conexão explicitamente se necessário
        }
    }

}
