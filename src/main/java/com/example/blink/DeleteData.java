package com.example.blink;

import com.example.blink.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteData {
    public static void main(String[] args) {
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
