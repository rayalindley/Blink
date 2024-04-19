package com.example.blink;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {
    public static void main(String[] args) {
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
}
