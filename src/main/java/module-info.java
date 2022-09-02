module com.example.compilador {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.fxmisc.flowless;
    requires org.fxmisc.richtext;


    opens com.example.compilador to javafx.fxml;
    exports com.example.compilador;
}