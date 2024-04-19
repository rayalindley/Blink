package com.example.blink;

import java.sql.*;

public class MySQLConnection {
    public static final String URL = "jdbc:mysql://localhost:3306/dbblink";
    public static final String username = "root";
    public static final String password = "";

    static Connection getConnection() {
        Connection c = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(URL, username, password);
            System.out.println("Database Connected!");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return c;
    }

    public static void main(String[] args) {
        getConnection();
    }

    public static void createTable() {
        try(Connection c = MySQLConnection.getConnection();
            Statement statement = c.createStatement()) {
            String query = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "firstname VARCHAR(50) NOT NULL," +
                    "lastname VARCHAR(50) NOT NULL," +
                    "email VARCHAR(50) NOT NULL)" +
                    "username VARCHAR(50) NOT NULL)" +
                    "password VARCHAR(50) NOT NULL,";
            statement.execute(query);
            System.out.println("Table created successfully!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertData(String fname, String lname, String email, String username, String password) {
        try(Connection c = MySQLConnection.getConnection();
            PreparedStatement statement = c.prepareStatement(
                    "INSERT INTO users (firstname, lastname, email, username, password) VALUES (?, ?, ?, ?, ?)"
            )) {
            statement.setString(1, fname);
            statement.setString(2, lname);
            int rows = statement.executeUpdate();
            System.out.println("Rows inserted: " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
