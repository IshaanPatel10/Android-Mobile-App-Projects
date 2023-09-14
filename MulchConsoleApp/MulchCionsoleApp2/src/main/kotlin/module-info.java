module com.example.mulchcionsoleapp2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens com.example.mulchcionsoleapp2 to javafx.fxml;
    exports com.example.mulchcionsoleapp2;
}