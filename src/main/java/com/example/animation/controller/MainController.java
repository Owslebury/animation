package com.example.animation.controller;

import com.example.animation.timeline.StartTimeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;

public class MainController {

    @FXML
    private ScrollPane scrollPane;

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

    }



}
