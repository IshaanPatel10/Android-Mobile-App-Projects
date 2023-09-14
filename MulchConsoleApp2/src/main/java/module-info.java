module com.example.mulchconsoleapp2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens com.example.mulchconsoleapp2 to javafx.fxml;
    exports com.example.mulchconsoleapp2;
}