module com.example.compilador {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.compilador to javafx.fxml;
    exports com.example.compilador;
}