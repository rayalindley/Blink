package com.example.blink;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SignInController {
    public TextField username;
    public PasswordField password;
    public VBox paneSignIn;
    public static String currUsername;

    public static String getCurrUsername() {
        return currUsername;
    }

    @FXML
    public void signIn(ActionEvent actionEvent) {
        String uname = username.getText();
        String pass = password.getText();

        if(!uname.isEmpty() && !pass.isEmpty()) {
            try(Connection c = MySQLConnection.getConnection();
                Statement statement = c.createStatement()) {
                String query = "SELECT * FROM users WHERE username='"+uname+"'";
                ResultSet res = statement.executeQuery(query);

                while(res.next()) {
                    String pword = res.getString("password");

                    if(pword.equals(pass)) {
                        currUsername = uname;

                        AnchorPane p = (AnchorPane) paneSignIn.getParent();
                        Parent scene =  FXMLLoader.load(getClass().getResource("home-view.fxml"));
                        p.getChildren().clear();
                        p.getChildren().add(scene);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void signUp(ActionEvent actionEvent) throws IOException {
        AnchorPane p = (AnchorPane) paneSignIn.getParent();
        Parent scene =  FXMLLoader.load(getClass().getResource("signup-view.fxml"));
        p.getChildren().clear();
        p.getChildren().add(scene);
    }
}