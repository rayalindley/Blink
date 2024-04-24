package com.example.blink;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ProfileController {
    public Label editableLabel;
    public TextField editableTextField;
    public Button btnEdit;
    public GridPane profileGrid;
    public Button btnSave;
    public Button btnBack;
    public Button btnLogOut;
    public VBox paneProfile;



    private void toPage(String fxmlfile) throws IOException {
        AnchorPane p = (AnchorPane) paneProfile.getParent();
        Parent scene =  FXMLLoader.load(getClass().getResource(fxmlfile));
        p.getChildren().clear();
        p.getChildren().add(scene);
    }

    public void editProfile() {
        profileGrid.getChildren().forEach(node -> {
            if(node instanceof TextField) {
                TextField txtFields = (TextField) node;
                txtFields.setEditable(true);
            }
        });

        btnEdit.setVisible(false);
        btnSave.setVisible(true);
    }

    public void saveProfile() {
        profileGrid.getChildren().forEach(node -> {
            if(node instanceof TextField) {
                TextField txtFields = (TextField) node;
                txtFields.setEditable(true);
            }
        });



        btnEdit.setVisible(true);
        btnSave.setVisible(false);
    }

    public void backToHome(ActionEvent actionEvent) throws IOException {
        toPage("home-view.fxml");
    }

    public void logOut(ActionEvent actionEvent) throws IOException {
        toPage("signin-view.fxml");
    }
}
