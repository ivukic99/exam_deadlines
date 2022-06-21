module com.example.ispitni_rokovi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.ispitni_rokovi to javafx.fxml;
    exports com.example.ispitni_rokovi;
    exports com.example.ispitni_rokovi.controllers;
    opens com.example.ispitni_rokovi.controllers to javafx.fxml;
}