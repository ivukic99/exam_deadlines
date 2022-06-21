package com.example.ispitni_rokovi.controllers;

import com.example.ispitni_rokovi.Program;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LoginController {
    /*@FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }*/

    @FXML
    protected void login(ActionEvent e){
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Program.swapScene(stage, "home.fxml", "Ispitni rokovi - home");
    }

    @FXML
    protected void goToSingUp(ActionEvent e){
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Program.swapScene(stage, "sing-up.fxml", "Sing up");
    }
}