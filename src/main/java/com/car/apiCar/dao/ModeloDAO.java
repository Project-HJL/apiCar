package com.car.apiCar.dao;

import com.car.apiCar.model.Modelo;
import com.car.apiCar.config.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModeloDAO {

    public boolean cadastrarModelo(Modelo modelo) {
        String sql = "INSERT INTO modelo (marca, nomeModelo, ano, versao) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, modelo.getMarca());
            ps.setString(2, modelo.getNomeModelo());
            ps.setInt(3, modelo.getAno());
            ps.setString(4, modelo.getVersao());
            System.out.println("Modelo cadastrado");
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Modelo> listarTodosModelos() {
        List<Modelo> modelos = new ArrayList<>();
        String sql = "SELECT id, marca, nomeModelo, ano, versao FROM modelo";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Modelo modelo = new Modelo(
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("nomeModelo"),
                        rs.getInt("ano"),
                        rs.getString("versao")
                );
                modelos.add(modelo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modelos;
    }
}
