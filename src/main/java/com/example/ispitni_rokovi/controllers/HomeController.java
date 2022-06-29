package com.example.ispitni_rokovi.controllers;

import com.example.ispitni_rokovi.Program;
import com.example.ispitni_rokovi.models.Collegium;
import com.example.ispitni_rokovi.models.Exam_deadline;
import com.example.ispitni_rokovi.models.Table;
import com.example.ispitni_rokovi.models.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    ChoiceBox cb_coll;

    @FXML
    ChoiceBox cb_user;

    @FXML
    DatePicker df_exam_date;

    @FXML
    DatePicker df_application;

    @FXML
    DatePicker df_cancel;

    @FXML
    Button btn_submit;

    @FXML
    Button delete_btn;

    @FXML
    TableColumn col_coll;
    @FXML
    TableColumn col_user;
    @FXML
    TableColumn col_ed;
    @FXML
    TableColumn col_apply;
    @FXML
    TableColumn col_cancel;
    @FXML
    TableColumn col_action;
    @FXML
    TableView tb_all_ed;

    @FXML
    protected void logout(ActionEvent e){
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Program.swapScene(stage, "login.fxml", "Login");
    }

    User user = new User();
    Collegium coll = new Collegium();
    Exam_deadline selectedExam_deadline;

    @FXML
    protected void selectExam_deadline(){
        this.selectedExam_deadline = (Exam_deadline) this.tb_all_ed.getSelectionModel().getSelectedItem();
        this.delete_btn.setDisable(false);
        //System.out.println(selectedExam_deadline.getCollegium_name());
        //System.out.println(selectedExam_deadline.getUser_id());
        //this.df_exam_date.setValue(LocalDate.parse(selectedExam_deadline.getExam_date()));
        //this.df_application.setValue(LocalDate.parse((selectedExam_deadline.getApplication_exam_date())));
        //this.df_cancel.setValue(LocalDate.parse((selectedExam_deadline.getCancel_exam_date())));
    }

    @FXML
    protected void deleteExam_deadline() throws Exception {
        if(selectedExam_deadline != null){
            this.selectedExam_deadline.delete();
            this.fillExam_deadlines();
        }
    }


    public <cls> void fillChoiceBox(ChoiceBox choiceBox, Class cls) throws Exception {
        ObservableList<cls> result = (ObservableList<cls>) FXCollections.observableArrayList(Table.list(cls));
        choiceBox.setItems(result);
    }
    @FXML
    protected void submitDeadline(ActionEvent e) throws Exception {
        //System.out.println(this.cb_coll.getValue());
        //System.out.println(this.cb_user.getValue());
        if(this.cb_user.getValue() != null && this.cb_coll.getValue() != null && this.df_exam_date.getValue() != null && this.df_application.getValue() != null && this.df_cancel.getValue() != null){
            Exam_deadline ed = new Exam_deadline();
            String ff = Table.getUserId(User.class, this.user.getEmail());
            ed.setUser_id(Integer.parseInt(ff));
            ed.setCollegium_name(this.coll.getName());
            ed.setExam_date(this.df_exam_date.getValue().toString());
            ed.setApplication_exam_date(this.df_application.getValue().toString());
            ed.setCancel_exam_date(this.df_cancel.getValue().toString());
            ed.save();
            System.out.println("Spremljeno");
            this.fillExam_deadlines();
        }
    }

    private void fillExam_deadlines (){
        try {
            ObservableList<?> exam_deadlines = FXCollections.observableList(Table.list(Exam_deadline.class));
            this.tb_all_ed.setItems(exam_deadlines);
        } catch (Exception e) {
            System.out.println("Nastala je greška: " + e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            fillChoiceBox(cb_user, User.class);
            fillChoiceBox(cb_coll, Collegium.class);
            cb_user.setOnAction(e -> {
                String selectedUser = cb_user.getSelectionModel().getSelectedItem().toString();
                this.user.setEmail(selectedUser);
            });
            cb_coll.setOnAction(e -> {
                String selectedColl = cb_coll.getSelectionModel().getSelectedItem().toString();
                this.coll.setName(selectedColl);
            });

        } catch (Exception e) {
            System.out.println("nastala je greska na initializaciji u homecontrolleru " + e.getMessage());
        }
        this.col_coll.setCellValueFactory(new PropertyValueFactory<>("collegium_name"));
        this.col_user.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        this.col_ed.setCellValueFactory(new PropertyValueFactory<>("exam_date"));
        this.col_apply.setCellValueFactory(new PropertyValueFactory<>("application_exam_date"));
        this.col_cancel.setCellValueFactory(new PropertyValueFactory<>("cancel_exam_date"));
        //this.col_action.setCellValueFactory(new PropertyValueFactory<>("cancel_exam_date"));
        this.fillExam_deadlines();
    }
}
