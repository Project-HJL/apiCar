package com.car.apiCar.dao;

import com.car.apiCar.config.*;
import com.car.apiCar.model.*; // Importar a classe UsuarioSession

import java.sql.*;

public class UsuarioDAO {

    public Usuario cadastrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)";
        Usuario usuario1 = null;

        try (
                Connection conn = Conexao.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            // Habilitar auto-commit
            conn.setAutoCommit(true);

            // Definir os parâmetros do PreparedStatement
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());

            // Executar o comando de inserção
            ps.executeUpdate();
            usuario1 = new Usuario(pegarId(usuario.getEmail()), usuario.getNome(), usuario.getEmail());
            UsuarioSession.getInstance().setUsuario(usuario1); // Armazenar na sessão
            System.out.println("Cadastro:\n" + "ID:" + usuario1.getId() + "\nEmail:" + usuario1.getEmail() + "\nNome:" + usuario1.getNome());
            System.out.println("Usuario cadastrado");


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao cadastrar usuário Dao.");
        } finally {
            Conexao.fecharConexao();
        }
        return usuario1;
    }

    public Usuario loginUsuario(Usuario usuario) {
        String sql = "SELECT id, nome, senha FROM usuario WHERE email = ? AND senha = ?";
        Usuario usuario1 = null;

        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            conn.setAutoCommit(true);
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getSenha());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) { // Verifica se encontrou o usuário
                usuario1 = new Usuario(pegarId(usuario.getEmail()), usuario.getNome(), usuario.getEmail());
                UsuarioSession.getInstance().setUsuario(usuario1); // Armazenar na sessão
                System.out.println("Login:\n" + "ID:" + usuario1.getId() + "\nEmail:" + usuario1.getEmail());
                System.out.println("Usuario Logado");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            Conexao.fecharConexao();
        }
        return usuario1;
    }

    public boolean editarSenhaUsuario(String novaSenha) {
        Usuario usuario = UsuarioSession.getInstance().getUsuario(); // Obtendo o usuário da sessão
        if (usuario == null) {
            System.out.println("Usuário não está logado.");
            return false;
        }

        String sql = "UPDATE usuario SET senha = ? WHERE id = ?";

        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            conn.setAutoCommit(true);

            ps.setString(1, novaSenha);
            ps.setInt(2, usuario.getId());

            Boolean result = ps.executeUpdate() > 0;
            System.out.println("Senha alterada com sucesso.");
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            Conexao.fecharConexao();
        }
    }

    public boolean excluirUsuario() {
        Usuario usuario = UsuarioSession.getInstance().getUsuario(); // Obtendo o usuário da sessão
        if (usuario == null) {
            System.out.println("Usuário não está logado.");
            return false;
        }

        String sql = "DELETE FROM usuario WHERE id = ?";

        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            conn.setAutoCommit(true);

            ps.setInt(1, usuario.getId());

            System.out.println("Usuario Excluido");
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            Conexao.fecharConexao();
        }
    }

    public boolean emailExiste(String email) {
        String sql = "SELECT id FROM usuario WHERE email = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            Conexao.fecharConexao();
        }
    }

    public int pegarId(String email) {
        String sql = "SELECT id FROM usuario WHERE email = ?";
        int id = 0;

        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return id;
    }

}