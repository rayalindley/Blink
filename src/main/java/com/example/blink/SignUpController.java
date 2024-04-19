package com.example.blink;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class SignUpController {
    public TextField fname;
    public TextField lname;
    public TextField emailadd;
    public TextField uname;
    public TextField pass;
    public Button register;
    public VBox paneSignUp;
    MySQLConnection mySQLConnection;


    public void register(ActionEvent actionEvent) throws IOException {
        String firstname = fname.getText();
        String lastname = fname.getText();
        String email = emailadd.getText();
        String username = uname.getText();
        String password = pass.getText();

        MySQLConnection.createTable();
        MySQLConnection.insertData(firstname, lastname, email, username, password);


        AnchorPane p = (AnchorPane) paneSignUp.getParent();
        Parent scene =  FXMLLoader.load(getClass().getResource("signin-view.fxml"));
        p.getChildren().clear();
        p.getChildren().add(scene);
    }
}
