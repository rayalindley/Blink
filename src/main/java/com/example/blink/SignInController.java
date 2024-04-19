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

public class SignInController {
    public TextField username;
    public PasswordField password;
    public Button signIn;
    public Button signUp;
    public VBox paneSignIn;

    @FXML
    public void signIn(ActionEvent actionEvent) {

    }

    public void signUp(ActionEvent actionEvent) throws IOException {
        AnchorPane p = (AnchorPane) paneSignIn.getParent();
        Parent scene =  FXMLLoader.load(getClass().getResource("signup-view.fxml"));
        p.getChildren().clear();
        p.getChildren().add(scene);
    }
}