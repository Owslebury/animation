package com.example.animation;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

/**
 *
 * @web http://java-buddy.blogspot.com/
 */
public class JavaFX_MouseEvent extends Application {

    Label label;

    Path path;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void scalePath(double scaleFactor) {
        for (var element : path.getElements()) {
            if (element instanceof MoveTo) {
                MoveTo moveTo = (MoveTo) element;
                moveTo.setX(moveTo.getX() * scaleFactor);
                moveTo.setY(moveTo.getY() * scaleFactor);
            } else if (element instanceof LineTo) {
                LineTo lineTo = (LineTo) element;
                lineTo.setX(lineTo.getX() * scaleFactor);
                lineTo.setY(lineTo.getY() * scaleFactor);
            }
        }
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("java-buddy.blogspot.com");
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250);

        label = new Label("Wait mouse");

        path = new Path();
        path.setStrokeWidth(10);
        path.setStroke(Color.BLACK);


        scene.setOnMouseClicked(mouseHandler);
        scene.setOnMouseDragged(mouseHandler);
        scene.setOnMouseEntered(mouseHandler);
        scene.setOnMouseExited(mouseHandler);
        scene.setOnMouseMoved(mouseHandler);
        scene.setOnMousePressed(mouseHandler);
        scene.setOnMouseReleased(mouseHandler);

        root.getChildren().add(label);
        root.getChildren().add(path);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent mouseEvent) {
            label.setText(mouseEvent.getEventType() + "\n"
                    + "X : Y - " + mouseEvent.getX() + " : " + mouseEvent.getY() + "\n"
                    + "SceneX : SceneY - " + mouseEvent.getSceneX() + " : " + mouseEvent.getSceneY() + "\n"
                    + "ScreenX : ScreenY - " + mouseEvent.getScreenX() + " : " + mouseEvent.getScreenY());

            if(mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED){
                //path.getElements().clear();
                scalePath(1.5);
                path.getElements().add(new MoveTo(mouseEvent.getX(), mouseEvent.getY()));
            }else if(mouseEvent.getEventType() == MouseEvent.MOUSE_DRAGGED){
                path.getElements().add(new LineTo(mouseEvent.getX(), mouseEvent.getY()));
            }

        }

    };

}