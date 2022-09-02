package com.example.compilador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class CompiladorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CompiladorApplication.class.getResource("compilador-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        CompiladorController controller = fxmlLoader.getController();
        scene.addEventFilter(KeyEvent.KEY_RELEASED, event -> controller.gerenciarAtalhos(event));

        stage.setMinHeight(600);
        stage.setMinWidth(910);
        stage.setTitle("Interface - Compilador - FURB");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}