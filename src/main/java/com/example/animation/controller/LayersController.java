package com.example.animation.controller;

import com.example.animation.Layer;
import com.example.animation.data.LayersData;
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
    private TreeItem<String> selectedLayer;

    @FXML
    protected void initialize() {
        // Create a dummy root node
        TreeItem<String> root = new TreeItem<>("Layers");
        root.setExpanded(true);
        layers.setRoot(root);
        selectedLayer = root;

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
        layers.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                selectedLayer = newValue;
                System.out.println("Selected Node: " + newValue.getValue());
                // Add any additional actions or logic here based on the selected node
            }
        });
    }

    private void handleRename() {
        TextInputDialog dialog = new TextInputDialog(selectedLayer.getValue());
        dialog.setTitle("Rename Node");
        dialog.setHeaderText("Enter new name:");
        dialog.setContentText("New Name:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(name -> selectedLayer.setValue(name));
    }

    @FXML
    public void addLayer(ActionEvent actionEvent) {
        // Example of adding a new group
        TreeItem<String> newLayer = new TreeItem<>("New Layer");
        selectedLayer.getChildren().add(newLayer);
        Layer layer = new Layer(newLayer);
        if (isChildOfRoot(newLayer)){
            LayersData.getInstance().addLayer(layer);
        }
    }

    private boolean isChildOfRoot(TreeItem<String> item) {
        TreeItem<String> parent = item.getParent();
        return parent != null && parent == layers.getRoot();
    }
}
