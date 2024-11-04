package com.car.apiCar.dao;

import com.car.apiCar.model.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.car.apiCar.config.*;

public class MensagemDAO {

    // Método para listar todas as mensagens de uma conversa
    public List<Mensagem> listarMensagensPorConversa(Conversa conversa) {
        String sql = "SELECT * FROM mensagem WHERE fk_Conversa_id = ?";
        List<Mensagem> mensagens = new ArrayList<>();

        try (Connection conn = Conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, conversa.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mensagem mensagem = new Mensagem(
                        rs.getInt("id"),
                        rs.getString("conteudo"),
                        rs.getString("tipo"),
                        rs.getDate("data_hora"),
                        conversa
                );
                mensagens.add(mensagem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mensagens;
    }

 // Método para inserir uma nova mensagem
    public boolean inserirMensagem(Mensagem mensagem) {
        String sql = "INSERT INTO mensagem (conteudo, tipo, data_hora, fk_Conversa_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            // Verifica se o objeto mensagem não é nulo
            if (mensagem == null) {
                System.out.println("Mensagem é nula.");
                return false;
            }

            // Logs para depuração
            System.out.println("Tentando inserir a mensagem:");
            System.out.println("Conteúdo: " + mensagem.getConteudo());
            System.out.println("Tipo: " + mensagem.getTipo());
            System.out.println("Data Hora: " + mensagem.getDataHora());
            System.out.println("ID da Conversa: " + mensagem.getConversa().getId());

            // Validações simples
            if (mensagem.getConteudo() == null || mensagem.getConteudo().isEmpty()) {
                System.out.println("Erro: Conteúdo não pode ser nulo ou vazio.");
                return false;
            }
            if (!mensagem.getTipo().equals("bot") && !mensagem.getTipo().equals("user")) {
                System.out.println("Erro: Tipo deve ser 'bot' ou 'user'.");
                return false;
            }
            if (mensagem.getDataHora() == null) {
                System.out.println("Erro: Data hora não pode ser nula.");
                return false;
            }

            // Define os parâmetros do PreparedStatement
            ps.setString(1, mensagem.getConteudo());
            ps.setString(2, mensagem.getTipo());
            ps.setDate(3, new java.sql.Date(mensagem.getDataHora().getTime())); // Conversão para java.sql.Date
            ps.setInt(4, mensagem.getConversa().getId());

            // Executa a atualização e verifica o resultado
            int rowsAffected = ps.executeUpdate();
            System.out.println("Linhas afetadas: " + rowsAffected);
            return rowsAffected > 0; // Retorna true se a inserção foi bem-sucedida
        } catch (SQLException e) {
            e.printStackTrace(); // Exibe a pilha de erros
            return false; // Retorna false se houve um erro
        }
    }

}
