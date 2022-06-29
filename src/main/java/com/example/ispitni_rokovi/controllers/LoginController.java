package com.example.ispitni_rokovi.controllers;

import com.example.ispitni_rokovi.Program;
import com.example.ispitni_rokovi.models.Table;
import com.example.ispitni_rokovi.models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    TextField tf_email;

    @FXML
    PasswordField pf_password;

    /*@FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }*/

    @FXML
    protected void login(ActionEvent e) throws Exception {
        if(Table.checkUser(User.class, tf_email.getText(), pf_password.getText())){
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            Program.swapScene(stage, "home.fxml", "Ispitni rokovi - home");
        }else{
            System.out.println("nesto ne radi");

        }
    }

    @FXML
    protected void goToSingUp(ActionEvent e){
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Program.swapScene(stage, "sing-up.fxml", "Sing up");
    }
}