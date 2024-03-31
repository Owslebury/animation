package com.example.animation.controller;

import com.example.animation.timeline.StartTimeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TreeView;

public class LayersController {
    @FXML
    private TreeView<String> layers;
    @FXML
    protected void initialize() {
        StartTimeline start = new StartTimeline();
        layers.setRoot(start.initializeLayers());
    }

    public void addLayer(ActionEvent actionEvent) {
    }
}
