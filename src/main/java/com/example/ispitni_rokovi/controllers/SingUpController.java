package com.example.ispitni_rokovi.controllers;

import com.example.ispitni_rokovi.Program;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class SingUpController {
    @FXML
    protected void singUp(ActionEvent e){
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Program.swapScene(stage, "login.fxml", "Login");
    }

    @FXML
    protected void goToLogin(ActionEvent e){
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Program.swapScene(stage, "login.fxml", "Login");
    }
}
