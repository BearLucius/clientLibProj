module com.example.serverclient {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.serverclient to javafx.fxml;
    exports com.example.serverclient;
}