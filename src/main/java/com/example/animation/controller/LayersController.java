package com.example.animation.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class LayersController {
    @FXML
    private TreeView<String> layers;

    @FXML
    protected void initialize() {
        // Create a dummy root node
        TreeItem<String> dummyRoot = new TreeItem<>("Layers");
        dummyRoot.setExpanded(true); // Optional: Expand the dummy root node

        // Create and add root-like nodes (groups)
        TreeItem<String> group1 = new TreeItem<>("Group 1");
        TreeItem<String> group2 = new TreeItem<>("Group 2");
        dummyRoot.getChildren().addAll(group1, group2);

        // Create and add child layers to groups
        TreeItem<String> layer1 = new TreeItem<>("Layer 1");
        TreeItem<String> layer2 = new TreeItem<>("Layer 2");
        group1.getChildren().addAll(layer1, layer2);

        layers.setRoot(dummyRoot); // Set the dummy root as the root of the TreeView
    }

    @FXML
    public void addLayer(ActionEvent actionEvent) {
        // Example of adding a new layer to "Group 1"
        TreeItem<String> group1 = layers.getRoot().getChildren().get(0); // Assuming "Group 1" is at index 0
        TreeItem<String> newLayer = new TreeItem<>("New Layer");
        group1.getChildren().add(newLayer);
    }

    @FXML
    public void addGroup(ActionEvent actionEvent) {
        // Example of adding a new group
        TreeItem<String> dummyRoot = layers.getRoot();
        TreeItem<String> newGroup = new TreeItem<>("New Group");
        dummyRoot.getChildren().add(newGroup);
    }
}
