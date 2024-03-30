package com.example.animation;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class JavaFX_MouseEvent extends Application {

    Path path;
    List<Path> enclosedPaths = new ArrayList<>();
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
        scene.setOnMouseReleased(mouseReleasedHandler);

        Button btnUp = new Button("Up");
        Button btnDown = new Button("Down");
        Button btnLeft = new Button("Left");
        Button btnRight = new Button("Right");

        btnUp.setOnAction(e -> movePath(0, -10));
        btnDown.setOnAction(e -> movePath(0, 10));
        btnLeft.setOnAction(e -> movePath(-10, 0));
        btnRight.setOnAction(e -> movePath(10, 0));

        HBox buttonBox = new HBox(10, btnUp, btnDown, btnLeft, btnRight);
        buttonBox.setLayoutX(10);
        buttonBox.setLayoutY(10);

        root.getChildren().addAll(path, buttonBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    EventHandler<MouseEvent> mousePressedHandler = mouseEvent -> {
        path.getElements().add(new MoveTo(mouseEvent.getX(), mouseEvent.getY()));
    };

    EventHandler<MouseEvent> mouseDraggedHandler = mouseEvent -> {
        path.getElements().add(new LineTo(mouseEvent.getX(), mouseEvent.getY()));
    };

    EventHandler<MouseEvent> mouseReleasedHandler = mouseEvent -> {
        // Create a new Path for enclosed spaces and fill them with color
        Path enclosedPath = new Path();
        enclosedPath.setFill(Color.BLUE); // Change color as needed
        enclosedPath.getElements().addAll(path.getElements());
        enclosedPaths.add(enclosedPath);
        Group root = (Group) path.getParent();
        root.getChildren().add(enclosedPath);

        // Clear the current path to start a new drawing
        path.getElements().clear();
    };

    private void movePath(double deltaX, double deltaY) {
        translateX += deltaX;
        translateY += deltaY;

        for (Path enclosedPath : enclosedPaths) {
            for (PathElement pathElement : enclosedPath.getElements()) {
                if (pathElement instanceof MoveTo) {
                    MoveTo move = (MoveTo) pathElement;
                    move.setX(move.getX() + deltaX);
                    move.setY(move.getY() + deltaY);
                } else if (pathElement instanceof LineTo) {
                    LineTo line = (LineTo) pathElement;
                    line.setX(line.getX() + deltaX);
                    line.setY(line.getY() + deltaY);
                }
            }
        }
    }
}
