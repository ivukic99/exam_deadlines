module com.example.ispitni_rokovi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.ispitni_rokovi to javafx.fxml;
    opens com.example.ispitni_rokovi.models to javafx.fxml;
    exports com.example.ispitni_rokovi;
    exports com.example.ispitni_rokovi.controllers;
    exports com.example.ispitni_rokovi.models;
    opens com.example.ispitni_rokovi.controllers to javafx.fxml;
}