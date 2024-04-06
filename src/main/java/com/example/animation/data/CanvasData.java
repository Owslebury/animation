package com.example.animation.data;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.layout.Pane;

public class CanvasData {
    private static CanvasData instance;
    private final ObjectProperty<Pane> canvas = new SimpleObjectProperty<>();

    public Pane getCanvas() {
        return canvas.get();
    }

    public void setCanvas(Pane canvas) {
        this.canvas.set(canvas);
    }

    public ObjectProperty<Pane> canvasProperty() {
        return canvas;
    }

    public static synchronized CanvasData getInstance() {
        if (instance == null) {
            instance = new CanvasData();
        }
        return instance;
    }
}
