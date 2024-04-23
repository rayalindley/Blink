package com.example.blink;

import java.sql.*;

public class UserTbl {
    public static void createTable() {
        try(Connection c = MySQLConnection.getConnection();
            Statement statement = c.createStatement()) {
            String query = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "firstname VARCHAR(50) NOT NULL," +
                    "lastname VARCHAR(50) NOT NULL," +
                    "email VARCHAR(50) NOT NULL," +
                    "username VARCHAR(50) NOT NULL," +
                    "password VARCHAR(50) NOT NULL)";
            statement.execute(query);
            System.out.println("Table created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertData(String fname, String lname, String email, String uname, String pass) {
        try(Connection c = MySQLConnection.getConnection();
            PreparedStatement statement = c.prepareStatement(
                    "INSERT INTO users (firstname, lastname, email, username, password) VALUES (?, ?, ?, ?, ?)"
            )) {
            statement.setString(1, fname);
            statement.setString(2, lname);
            statement.setString(3, email);
            statement.setString(4, uname);
            statement.setString(5, pass);
            int rows = statement.executeUpdate();
            System.out.println("Rows inserted: " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void readData(String[] args) {
        try(Connection c = MySQLConnection.getConnection();
            Statement statement = c.createStatement()) {
            String query = "SELECT * FROM users WHERE username=?";
            ResultSet res = statement.executeQuery(query);

            while(res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                String email = res.getString("email");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Email Address: " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateData(String[] args) {
        try(Connection c = MySQLConnection.getConnection();
            PreparedStatement statement = c.prepareStatement(
                    "UPDATE users SET name=? WHERE id=?"
                    //"UPDATE users SET id=? WHERE name=?"
                    //"UPDATE users SET email=? WHERE name=?"
            )) {
            String name = "Raya Lindley Dela Victoria Jaranilla";
            int id = 2;

            statement.setString(1, name);
            statement.setInt(2, id);
            int rows = statement.executeUpdate();
            System.out.println("Rows updated: " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteData(String[] args) {
        try(Connection c = MySQLConnection.getConnection();
            PreparedStatement statement = c.prepareStatement(
                    "DELETE FROM users WHERE id=? RETURNING *"
            )) {
            int id = 1;
            statement.setInt(1, id);
            int rows = statement.executeUpdate();

            ResultSet res = statement.getResultSet();
            if(res.next()) {
                System.out.println("Name: " + res.getString("name"));
                System.out.println("Email Address: " + res.getString("email"));
                System.out.println("Data deleted successfully!");
            }
            System.out.println("Rows deleted: " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
