package com.example.animation;

import javafx.beans.InvalidationListener;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TreeItem;
import javafx.scene.shape.Path;

import java.util.ArrayList;
import java.util.List;

public class Layer implements ObservableValue<Layer> {
    private TreeItem<String> treeItem;
    private Path graphic;
    private List<Layer> children = new ArrayList<>();
    private ObjectProperty<Layer> observableLayer = new SimpleObjectProperty<>(this);

    public Layer(TreeItem<String> treeItem) {
        this.treeItem = treeItem;
    }

    public TreeItem<String> getTreeItem() {
        return treeItem;
    }

    public void setTreeItem(TreeItem<String> selectedLayer) {
        this.treeItem = selectedLayer;
        notifyListeners();
    }

    public Path getGraphic() {
        return graphic;
    }

    public void setGraphic(Path graphic) {
        this.graphic = graphic;
        notifyListeners();
    }

    public List<Layer> getChildren() {
        return children;
    }

    public void setChildren(List<Layer> children) {
        this.children = children;
        notifyListeners();
    }

    @Override
    public void addListener(ChangeListener<? super Layer> listener) {
        observableLayer.addListener(listener);
    }

    @Override
    public void removeListener(ChangeListener<? super Layer> listener) {
        observableLayer.removeListener(listener);
    }

    @Override
    public Layer getValue() {
        return observableLayer.get();
    }

    private void notifyListeners() {
        observableLayer.set(this); // Trigger change
    }

    @Override
    public void addListener(InvalidationListener invalidationListener) {

    }

    @Override
    public void removeListener(InvalidationListener invalidationListener) {

    }
}
