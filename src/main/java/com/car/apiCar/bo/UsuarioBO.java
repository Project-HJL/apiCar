package com.car.apiCar.bo;

import com.car.apiCar.dao.UsuarioDAO;
import com.car.apiCar.model.*;


public class UsuarioBO {

    private UsuarioDAO usuarioDAO;

    public UsuarioBO() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public Usuario cadastrarUsuario(String nome, String email, String senha) {
         //Regra de negócio, por exemplo, verificar se o e-mail já existe
        if (usuarioDAO.emailExiste(email)) {
            System.out.println("Email já cadastrado.");
            return null;
        }
         //Verificação de senha
        else if (senha.length() < 6) {
            System.out.println("A senha precisa ter pelo menos 6 caracteres.");
            return null;
        }
        else{
            Usuario usuario = new Usuario(nome, email, senha);
            return usuarioDAO.cadastrarUsuario(usuario);
        }
    }

    public Usuario loginUsuario(String email, String senha) {
        // Regras de login, como verificar se o e-mail ou a senha estão corretos
        if (email.isEmpty() || senha.isEmpty()) {
            System.out.println("Email e senha são obrigatórios.");
            return null;
        }

        Usuario usuario = new Usuario(email, senha);
        return usuarioDAO.loginUsuario(usuario);
    }

    public boolean editarSenhaUsuario(String novaSenha) {
        // Verificação de senha
        if (novaSenha.length() < 6) {
            System.out.println("A senha precisa ter pelo menos 6 caracteres.");
            return false;
        }

        return usuarioDAO.editarSenhaUsuario(novaSenha);
    }

    public boolean excluirUsuario() {
        return usuarioDAO.excluirUsuario();
    }
}
