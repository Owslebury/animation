package com.example.animation.toolbox;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Draw {
    private Path path;
    private Pane canvas;

    public Draw(Pane canvas) {
        this.canvas = canvas;
        initialize();
    }

    private void initialize() {
        path = new Path();
        path.setStrokeWidth(2);
        path.setStroke(Color.BLACK);
        canvas.getChildren().add(path); // Add path to the canvas Pane

        // Set mouse event handlers
        canvas.setOnMousePressed(mousePressedHandler);
        canvas.setOnMouseDragged(mouseDraggedHandler);
    }

    EventHandler<MouseEvent> mousePressedHandler = mouseEvent -> {
        path.getElements().add(new MoveTo(mouseEvent.getX(), mouseEvent.getY()));
    };

    EventHandler<MouseEvent> mouseDraggedHandler = mouseEvent -> {
        path.getElements().add(new LineTo(mouseEvent.getX(), mouseEvent.getY()));
    };

    public void disableDrawing() {
        canvas.setOnMousePressed(null);
        canvas.setOnMouseDragged(null);
    }
    }
