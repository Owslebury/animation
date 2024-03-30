package com.example.animation.controller;

import com.example.animation.toolbox.Draw;
import com.example.animation.toolbox.ToolboxController;
import com.example.animation.toolbox.data.ToolData;
import com.example.animation.toolbox.data.Toolmode;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class CanvasController {
    @FXML
    private Pane canvasContainer;
    private double orgSceneX, orgSceneY;
    private double orgTranslateX, orgTranslateY;

    private Draw draw;
    @FXML
    private Circle circle;
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

    private void disableDraggable() {
        circle.setOnMousePressed(null);
        circle.setOnMouseDragged(null);
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

    public void initialize(){
        ToolData.getInstance().toolmodeProperty().addListener(this::handleToolmodeChange);
    }

    private void handleToolmodeChange(Observable observable) {
        if (ToolData.getInstance().getToolmode() == Toolmode.SELECT){
            makeDraggable();
        }
        else{
            disableDraggable();
        }
        if (ToolData.getInstance().getToolmode() == Toolmode.DRAW){
            enableDrawing();
        }
        else{
            disableDrawing();
        }
    }

    private void enableDrawing(){
        Draw draw = new Draw(canvasContainer);
        this.draw = draw;
    }

    private void disableDrawing(){
        if (draw != null){
            draw.disableDrawing();
        }
    }
}
