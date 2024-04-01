package com.example.animation;

import javafx.scene.control.TreeItem;
import javafx.scene.shape.Path;

import java.util.ArrayList;
import java.util.List;

public class Layer {
    private TreeItem<String> treeItem;
    private Path graphic;

    public Layer(TreeItem<String> treeItem) {
        this.treeItem = treeItem;
    }

    private List<Layer> children = new ArrayList<>();

    public TreeItem<String> getTreeItem() {
        return treeItem;
    }

    public void setTreeItem(TreeItem<String> selectedLayer) {
        this.treeItem = selectedLayer;
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
