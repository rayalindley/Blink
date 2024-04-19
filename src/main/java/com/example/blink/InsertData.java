package com.example.blink;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData {
    public static void insertData(String fname, String lname) {
        //Scanner sc = new Scanner(System.in);
        try(Connection c = MySQLConnection.getConnection();
            PreparedStatement statement = c.prepareStatement(
            "INSERT INTO users (firstname, lastname) VALUES (?, ?)"
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
