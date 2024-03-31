package com.example.animation.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.util.Optional;

public class LayersController {
    @FXML
    private TreeView<String> layers;
    private TreeItem<String> selectedNode;

    @FXML
    protected void initialize() {
        // Create a dummy root node
        TreeItem<String> root = new TreeItem<>("Layers");
        root.setExpanded(true);
        layers.setRoot(root);
        selectedNode = root; // Set the dummy root as the root of the TreeView

        // Create context menu items
        MenuItem renameItem = new MenuItem("Rename");
        renameItem.setOnAction(event -> handleRename());

        // Create context menu and add items
        ContextMenu contextMenu = new ContextMenu();
        contextMenu.getItems().add(renameItem);

        layers.setCellFactory(treeView -> new TreeCell<String>() {
            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(item);
                    setContextMenu(contextMenu);
                }
            }
        });

        layers.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                handleRename();
            }
        });

        layers.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                selectedNode = newValue;
                System.out.println("Selected Node: " + newValue.getValue());
                // Add any additional actions or logic here based on the selected node
            }
        });
    }

    private void handleRename() {
        TextInputDialog dialog = new TextInputDialog(selectedNode.getValue());
        dialog.setTitle("Rename Node");
        dialog.setHeaderText("Enter new name:");
        dialog.setContentText("New Name:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(name -> selectedNode.setValue(name));
    }

    @FXML
    public void addLayer(ActionEvent actionEvent) {
        // Example of adding a new group
        TreeItem<String> newGroup = new TreeItem<>("New Layer");
        selectedNode.getChildren().add(newGroup);
    }
}
