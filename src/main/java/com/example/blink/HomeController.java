package com.example.blink;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class HomeController {
    public Button btnProfile;


    public Button btnLogOut;
    public VBox paneHome;

    public void myProfile(ActionEvent actionEvent) throws IOException {

        AnchorPane p = (AnchorPane) paneHome.getParent();
        Parent scene = FXMLLoader.load(getClass().getResource("profile-view.fxml"));
        p.getChildren().clear();
        p.getChildren().add(scene);
    }

    public void logOut(ActionEvent actionEvent) {
    }
}
