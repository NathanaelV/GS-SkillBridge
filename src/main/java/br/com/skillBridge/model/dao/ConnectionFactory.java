package br.com.skillBridge.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                return connection;
            }

            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = System.getenv("DB_URL"); // "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
            final String USER = System.getenv("DB_USER");
            final String PASSWORD = System.getenv("DB_PASS");

            System.out.printf("\n\nURL: %s\nUser: %s\nPassword: %s\n", url, USER, PASSWORD);

            if (url == null || USER == null || PASSWORD == null) {
                throw new RuntimeException("Variáveis de ambiente do banco não configuradas!");
            }

            connection = DriverManager.getConnection(url, USER, PASSWORD);

        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Erro nome da classe: " + e.getMessage());
        }

        return connection;
    }

    public static void closeConnection() {
        try {
            if (!connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
