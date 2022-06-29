package com.example.ispitni_rokovi.controllers;

import com.example.ispitni_rokovi.Program;
import com.example.ispitni_rokovi.models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SingUpController {
    @FXML
    TextField tf_name;
    @FXML
    TextField tf_surname;
    @FXML
    TextField tf_email;
    @FXML
    PasswordField pf_password;

    @FXML
    protected void singUp(ActionEvent e) throws Exception {
        if(isValid(tf_name) && isValid(tf_surname) && isValid(tf_email) && isValid(pf_password)){
            User user = new User();
            user.setName(tf_name.getText());
            user.setSurname(tf_surname.getText());
            user.setEmail(tf_email.getText());
            user.setPassword(pf_password.getText());
            user.save();
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            Program.swapScene(stage, "login.fxml", "Login");
        }else {
            isValid(tf_name);
            isValid(tf_surname);
            isValid(tf_email);
            isValid(pf_password);
            System.out.println("Korisnik mora ispuniti sva polja!");
        }
    }

    @FXML
    protected void goToLogin(ActionEvent e){
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Program.swapScene(stage, "login.fxml", "Login");
    }

    protected boolean isValid(TextField value){
        if(value.getText().length() == 0){
            value.setStyle("-fx-border-color: red");
            return  false;
        }else {
            value.setStyle("-fx-border-color: green");
            return true;
        }
    }
}
