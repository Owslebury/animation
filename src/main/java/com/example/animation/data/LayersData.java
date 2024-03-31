package com.example.animation.data;

import com.example.animation.Layer;
import javafx.scene.control.TreeItem;
import javafx.scene.shape.Path;

import java.util.List;

public class LayersData {
    private static LayersData instance;
    private Layer currentLayer;

    public Layer getCurrentLayer() {
        return currentLayer;
    }

    public void setCurrentLayer(Layer currentLayer) {
        this.currentLayer = currentLayer;
    }

    private List<Layer> rootLayers;
    public static synchronized LayersData getInstance() {
        if (instance == null) {
            instance = new LayersData();
        }
        return instance;
    }

    public void addLayer(Layer layer){
        rootLayers.add(layer);
    }

}
