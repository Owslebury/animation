package com.example.animation.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class LayersController {
    @FXML
    private TreeView<String> layers;
    private TreeItem<String> selectedNode;

    @FXML
    protected void initialize() {
        // Create a dummy root node
        TreeItem<String> root = new TreeItem<>("Layers");
        root.setExpanded(true);
        root.expandedProperty().addListener((observable, oldValue, newValue) -> {
            root.setExpanded(true);
                });

        layers.setRoot(root);
        selectedNode = root;// Set the dummy root as the root of the TreeView
        layers.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                selectedNode = newValue;
                System.out.println("Selected Node: " + newValue.getValue());
                // Add any additional actions or logic here based on the selected node
            }
        });
    }
    @FXML
    public void addLayer(ActionEvent actionEvent) {
        // Example of adding a new group
        TreeItem<String> dummyRoot = layers.getRoot();
        TreeItem<String> newGroup = new TreeItem<>("New Layer");
        selectedNode.getChildren().add(newGroup);
    }
}
