package com.example.animation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setMaximized(true);
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("animator.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Animation");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}