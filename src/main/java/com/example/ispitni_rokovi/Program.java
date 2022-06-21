package com.example.ispitni_rokovi;

import com.example.ispitni_rokovi.models.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Program extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Prijavi se!");
        stage.setScene(scene);
        stage.show();
    }

    public static void swapScene(Stage stage, String viewName, String title){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource(viewName));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle(title);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Nastala je pogrešla: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        launch();
        /*Table.create(User.class);
        Table.create(Faculty.class);
        Table.create(Study_group.class);
        Table.create(Collegium.class);
        Table.create(StudyGroup_collegium.class);
        Table.create(Exam_deadline.class);

        User user = new User();
        user.setName("Test223");
        user.setSurname("Testic123");
        user.setEmail("test.testic123@fpmoz.sum.ba");
        user.setPassword("12345");
        user.save();*/
    }
}