package com.example.animation.toolbox;

import com.example.animation.Layer;
import com.example.animation.controller.LayersController;
import com.example.animation.data.CurrentLayerChangeListener;
import com.example.animation.data.LayersData;
import com.example.animation.data.ToolData;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Draw implements CurrentLayerChangeListener {
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

        LayersData.getInstance().addCurrentLayerChangeListener(this);

        updateDrawing();

        // Set mouse event handlers
        canvas.setOnMousePressed(mousePressedHandler);
        canvas.setOnMouseDragged(mouseDraggedHandler);
    }

    private void updateDrawing() {
        if (LayersData.getInstance().isSelectedChildOfRoot()) {
            LayersData.getInstance().getCurrentLayer().setGraphic(path);
            canvas.getChildren().add(LayersData.getInstance().getCurrentLayer().getGraphic());
        } else {
            canvas.getChildren().remove(path);
            LayersData.getInstance().getCurrentLayer().setGraphic(null);
        }
    }

    EventHandler<MouseEvent> mousePressedHandler = mouseEvent -> {
        if (LayersData.getInstance().isSelectedChildOfRoot()) {
            path.getElements().add(new MoveTo(mouseEvent.getX(), mouseEvent.getY()));
        }
    };

    EventHandler<MouseEvent> mouseDraggedHandler = mouseEvent -> {
        if (LayersData.getInstance().isSelectedChildOfRoot()) {
            path.getElements().add(new LineTo(mouseEvent.getX(), mouseEvent.getY()));
        }
    };

    public void disableDrawing() {
        canvas.setOnMousePressed(null);
        canvas.setOnMouseDragged(null);
    }

    @Override
    public void onCurrentLayerChanged(Layer newLayer) {
        updateDrawing();
    }
}
