package com.example.animation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RubberBandSelection extends Application {
    private double startX, startY;
    private Rectangle selectionBox;
    private Pane root;

    @Override
    public void start(Stage primaryStage) {
        root = new Pane();
        Scene scene = new Scene(root, 600, 400);

        // Initialize selection box
        selectionBox = new Rectangle(0, 0, 0, 0);
        selectionBox.setFill(Color.TRANSPARENT);
        selectionBox.setStroke(Color.BLUE);
        selectionBox.setStrokeWidth(2);
        root.getChildren().add(selectionBox);

        // Event handlers
        scene.setOnMousePressed(event -> {
            selectionBox.setStroke(Color.BLUE);
            startX = event.getX();
            startY = event.getY();
            selectionBox.setX(startX);
            selectionBox.setY(startY);
            selectionBox.setWidth(0);
            selectionBox.setHeight(0);
        });

        scene.setOnMouseDragged(event -> {
            double endX = event.getX();
            double endY = event.getY();
            double width = endX - startX;
            double height = endY - startY;
            selectionBox.setWidth(Math.abs(width));
            selectionBox.setHeight(Math.abs(height));
            selectionBox.setX(width < 0 ? endX : startX);
            selectionBox.setY(height < 0 ? endY : startY);
        });

        scene.setOnMouseReleased(event -> {
            // Add logic here to handle selection
            System.out.println("Selected items within the box!");
            selectionBox.setStroke(Color.TRANSPARENT);
        });

        primaryStage.setTitle("Rubber Band Selection");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
