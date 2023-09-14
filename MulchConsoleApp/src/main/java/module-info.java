module com.example.mulchconsoleapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mulchconsoleapp to javafx.fxml;
    exports com.example.mulchconsoleapp;
}