package com.example.animation;

import javafx.scene.control.TreeItem;
import javafx.scene.shape.Path;

import java.util.ArrayList;
import java.util.List;

public class Layer {
    private TreeItem<String> selectedLayer;
    private Path graphic;

    public Layer(TreeItem<String> selectedLayer) {
        this.selectedLayer = selectedLayer;
    }

    private List<Layer> children = new ArrayList<>();

    public TreeItem<String> getSelectedLayer() {
        return selectedLayer;
    }

    public void setSelectedLayer(TreeItem<String> selectedLayer) {
        this.selectedLayer = selectedLayer;
    }

    public Path getGraphic() {
        return graphic;
    }

    public void setGraphic(Path graphic) {
        this.graphic = graphic;
    }

    public List<Layer> getChildren() {
        return children;
    }

    public void setChildren(List<Layer> children) {
        this.children = children;
    }
}
