package com.example.animation.controller;

import com.example.animation.Layer;
import com.example.animation.data.CanvasData;
import com.example.animation.data.LayersData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

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
        Layer layer = new Layer(root, 0);
        LayersData.getInstance().setCurrentLayer(layer);
        LayersData.getInstance().setRootLayer(layer);
        selectedLayer = root;

        // Create context menu items
        MenuItem renameItem = new MenuItem("Rename");
        renameItem.setOnAction(event -> handleRename());
        MenuItem deleteItem = new MenuItem("Delete");
        deleteItem.setOnAction(event -> handleDelete());
        // Create context menu and add items
        ContextMenu contextMenu = new ContextMenu();
        contextMenu.getItems().add(renameItem);
        contextMenu.getItems().add(deleteItem);

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
                LayersData.getInstance().addLayerMapping(selectedLayer);
                Layer mappedLayer = LayersData.getInstance().getLayerForTreeItem(selectedLayer);
                LayersData.getInstance().setCurrentLayer(mappedLayer);
                System.out.println(mappedLayer.getLayerNumber());
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

    private void handleDelete() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Layer");
        alert.setHeaderText("Are you sure you want to delete this layer?");
        alert.setContentText("This action cannot be undone.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            TreeItem<String> parent = selectedLayer.getParent();
            //Remove graphics from the canvas
            Pane canvas = CanvasData.getInstance().getCanvas();
            canvas.getChildren().remove(LayersData.getInstance().getCurrentLayer().getGraphic());
            CanvasData.getInstance().setCanvas(canvas);
            if (parent != null) {
                parent.getChildren().remove(selectedLayer);
            }
        }
        System.out.println("DELETE CANVAS");
    }

    @FXML
    public void addLayer(ActionEvent actionEvent) {
        // Example of adding a new group
        TreeItem<String> newLayer = new TreeItem<>("New Layer");
        selectedLayer.getChildren().add(newLayer);
        if (isChildOfRoot(newLayer)){
            LayersData.getInstance().addLayerMapping(newLayer);
        }
    }

    public boolean isChildOfRoot(TreeItem<String> item) {
        TreeItem<String> parent = item.getParent();
        return parent != null && parent == layers.getRoot();
    }
}
