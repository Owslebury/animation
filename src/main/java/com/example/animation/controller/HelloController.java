package com.example.animation.controller;

import com.example.animation.timeline.StartTimeline;
import com.example.animation.toolbox.ToolboxController;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class HelloController {

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private TreeView<String> layers;
    @FXML
    private Button selectButton;
    @FXML
    private Button editButton;
    @FXML
    private Button fillButton;
    @FXML
    private Button scaleButton;


    @FXML
    protected void initialize() {
        StartTimeline start = new StartTimeline();
       HBox contentBox = start.startTimeline();
        scrollPane.setContent(contentBox);
        layers.setRoot(start.initializeLayers());

    }



}
