package com.car.apiCar.config;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class Conexao {

    //SELECT * FROM v$locked_object;
    //SET AUTOCOMMIT ON;

    private static Connection conn;

    // Retorna uma única instância da conexão
    public static Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            OracleDataSource ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl");
            ods.setUser(Credenciais.user);
            ods.setPassword(Credenciais.pwd);
            conn = ods.getConnection();
            System.out.println("\nConexao.getConnection");
        }
        return conn;
    }

    // Fecha a conexão
    public static void fecharConexao() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexão fechada");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static class Credenciais {
        public static final String user = "";//Colocar rm do usuario
        public static final String pwd = "";//Inserir senha do usuario
    }

}

