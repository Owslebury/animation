package com.example.animation;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class JavaFX_MouseEvent extends Application {

    Path path;
    Rectangle boundingBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing Application");
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600);

        path = new Path();
        path.setStrokeWidth(2);
        path.setStroke(Color.BLACK);

        boundingBox = new Rectangle();
        boundingBox.setStroke(Color.RED);
        boundingBox.setFill(Color.TRANSPARENT);

        scene.setOnMousePressed(mouseHandler);
        scene.setOnMouseDragged(mouseHandler);
        scene.setOnMouseReleased(mouseHandler);

        root.getChildren().addAll(path, boundingBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {
        double minX = Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE;
        double maxY = Double.MIN_VALUE;

        @Override
        public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED) {
                path.getElements().clear();
                minX = maxX = mouseEvent.getX();
                minY = maxY = mouseEvent.getY();
                path.getElements().add(new MoveTo(mouseEvent.getX(), mouseEvent.getY()));
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                path.getElements().add(new LineTo(mouseEvent.getX(), mouseEvent.getY()));
                minX = Math.min(minX, mouseEvent.getX());
                minY = Math.min(minY, mouseEvent.getY());
                maxX = Math.max(maxX, mouseEvent.getX());
                maxY = Math.max(maxY, mouseEvent.getY());
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED) {
                drawBoundingBox();
            }
        }

        private void drawBoundingBox() {
            boundingBox.setX(minX);
            boundingBox.setY(minY);
            boundingBox.setWidth(maxX - minX);
            boundingBox.setHeight(maxY - minY);
        }
    };
}
