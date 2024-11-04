package com.car.apiCar.dao;

import com.car.apiCar.config.Conexao;
import com.car.apiCar.model.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConversaDAO {

    public boolean criarConversa() {
        Usuario usuario = UsuarioSession.getInstance().getUsuario(); // Obtendo o usuário da sessão

        String sql = "INSERT INTO conversa (status, fk_Usuario_id) VALUES (?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, String.valueOf('A'));
            ps.setInt(2, usuario.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Conversa> listarConversasPorUsuario() {
        Usuario usuario = UsuarioSession.getInstance().getUsuario(); // Obtendo o usuário da sessão

        String sql = "SELECT * FROM conversa WHERE fk_Usuario_id = ?";
        List<Conversa> conversas = new ArrayList<>();

        try (Connection conn = Conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, usuario.getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Conversa conversa = new Conversa(
                        rs.getInt("id"),
                        rs.getString("status").charAt(0), usuario
                );
                if (conversa.getStatus() == 'A') {
                    conversas.add(conversa);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conversas;
    }

//    public boolean editarStatusConversa(Conversa conversa) {
//        String sql = "UPDATE conversa SET status = ? WHERE id = ?";
//
//        try (Connection conn = Conexao.getConnection();
//             PreparedStatement ps = conn.prepareStatement(sql)) {
//
//            ps.setString(1, "B");
//            ps.setInt(2, conversa.getId());
//            return ps.executeUpdate() > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
}
