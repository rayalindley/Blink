package com.example.blink;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class SignUpController {
    public TextField fname;
    public TextField lname;
    public TextField emailadd;
    public TextField uname;
    public Button register;
    public VBox paneSignUp;
    public PasswordField pass;

    private void toLogInPage() throws IOException {
        AnchorPane p = (AnchorPane) paneSignUp.getParent();
        Parent scene =  FXMLLoader.load(getClass().getResource("signin-view.fxml"));
        p.getChildren().clear();
        p.getChildren().add(scene);
    }


    public void register(ActionEvent actionEvent) throws IOException {
        String firstname = fname.getText();
        String lastname = fname.getText();
        String email = emailadd.getText();
        String username = uname.getText();
        String password = pass.getText();

        if(!firstname.isEmpty() && !lastname.isEmpty() && !email.isEmpty() && !username.isEmpty() && !password.isEmpty()) {
            UserTbl.createTable();
            UserTbl.insertData(firstname, lastname, email, username, password);
            toLogInPage();
        }
    }

    public void signIn(ActionEvent actionEvent) throws IOException {
        toLogInPage();
    }
}
