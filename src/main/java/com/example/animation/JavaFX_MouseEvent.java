package com.example.animation;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

public class JavaFX_MouseEvent extends Application {

    Path path;
    double translateX = 0;
    double translateY = 0;

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

        scene.setOnMousePressed(mousePressedHandler);
        scene.setOnMouseDragged(mouseDraggedHandler);

        Button btnUp = new Button("Up");
        Button btnDown = new Button("Down");
        Button btnLeft = new Button("Left");
        Button btnRight = new Button("Right");

        btnUp.setOnAction(e -> movePath(0, -10)); // Move up (negative translateY)
        btnDown.setOnAction(e -> movePath(0, 10)); // Move down (positive translateY)
        btnLeft.setOnAction(e -> movePath(-10, 0)); // Move left (negative translateX)
        btnRight.setOnAction(e -> movePath(10, 0)); // Move right (positive translateX)

        HBox buttonBox = new HBox(10, btnUp, btnDown, btnLeft, btnRight);
        buttonBox.setLayoutX(10);
        buttonBox.setLayoutY(10);

        root.getChildren().addAll(path, buttonBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    EventHandler<MouseEvent> mousePressedHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            path.getElements().add(new MoveTo(mouseEvent.getX(), mouseEvent.getY()));
        }
    };

    EventHandler<MouseEvent> mouseDraggedHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            path.getElements().add(new LineTo(mouseEvent.getX(), mouseEvent.getY()));
        }
    };

    private void movePath(double deltaX, double deltaY) {
        translateX += deltaX;
        translateY += deltaY;

        for (int i = 0; i < path.getElements().size(); i++) {
            if (path.getElements().get(i) instanceof MoveTo) {
                MoveTo move = (MoveTo) path.getElements().get(i);
                move.setX(move.getX() + deltaX);
                move.setY(move.getY() + deltaY);
            } else if (path.getElements().get(i) instanceof LineTo) {
                LineTo line = (LineTo) path.getElements().get(i);
                line.setX(line.getX() + deltaX);
                line.setY(line.getY() + deltaY);
            }
        }
    }
}
