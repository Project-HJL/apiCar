package com.car.apiCar.model;

public class UsuarioSession {
    private static UsuarioSession instance;
    private Usuario usuario;

    private UsuarioSession() {}

    public static synchronized UsuarioSession getInstance() {
        if (instance == null) {
            instance = new UsuarioSession();
        }
        return instance;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void clear() {
        this.usuario = null; // Limpar a sessão quando necessário
    }
}

