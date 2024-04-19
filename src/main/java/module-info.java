module com.example.blink {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.blink to javafx.fxml;
    exports com.example.blink;
}