package com.example.animation.controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class HelloController {
    @FXML
    private Circle circle;

    private double orgSceneX, orgSceneY;
    private double orgTranslateX, orgTranslateY;

    @FXML
    protected void initialize() {
        makeDraggable();
    }

    private void makeDraggable() {
        circle.setOnMousePressed((MouseEvent event) -> {
            orgSceneX = event.getSceneX();
            orgSceneY = event.getSceneY();
            orgTranslateX = ((Circle) (event.getSource())).getTranslateX();
            orgTranslateY = ((Circle) (event.getSource())).getTranslateY();
        });

        circle.setOnMouseDragged((MouseEvent event) -> {
            double offsetX = event.getSceneX() - orgSceneX;
            double offsetY = event.getSceneY() - orgSceneY;
            double newTranslateX = orgTranslateX + offsetX;
            double newTranslateY = orgTranslateY + offsetY;

            ((Circle) (event.getSource())).setTranslateX(newTranslateX);
            ((Circle) (event.getSource())).setTranslateY(newTranslateY);
        });
    }

    @FXML
    protected void onHelloButtonClick() {
        // Create a timeline for animation
        Timeline timeline = new Timeline();

        // Define keyframes for the animation
        KeyFrame startFrame = new KeyFrame(Duration.ZERO,
                new KeyValue(circle.centerXProperty(), 100),  // Initial X position of the circle
                new KeyValue(circle.centerYProperty(), 100)); // Initial Y position of the circle

        KeyFrame endFrame = new KeyFrame(Duration.seconds(2),
                new KeyValue(circle.centerXProperty(), 300),  // Final X position of the circle after 2 seconds
                new KeyValue(circle.centerYProperty(), 300)); // Final Y position of the circle after 2 seconds

        // Add keyframes to the timeline
        timeline.getKeyFrames().addAll(startFrame, endFrame);

        // Set cycle count and play the animation
        timeline.setCycleCount(Timeline.INDEFINITE); // Repeat indefinitely
        timeline.setAutoReverse(true); // Reverse animation on reaching the end
        timeline.play();
    }
}
