package com.example.animation.data;

import com.example.animation.Layer;
import javafx.scene.control.TreeItem;

import java.util.ArrayList;
import java.util.List;

public class LayersData {
    private static LayersData instance;
    private Layer rootLayer;
    private Layer currentLayer;

    public Layer getCurrentLayer() {
        return currentLayer;
    }

    public void setCurrentLayer(Layer currentLayer) {
        this.currentLayer = currentLayer;
        System.out.println("Selected layer changed");
    }

    private List<Layer> rootLayers = new ArrayList<>();
    public static synchronized LayersData getInstance() {
        if (instance == null) {
            instance = new LayersData();
        }
        return instance;
    }

    public void addLayer(Layer layer){
        rootLayers.add(layer);
    }

    public Layer getRootLayer() {
        return rootLayer;
    }

    public void setRootLayer(Layer rootLayer) {
        this.rootLayer = rootLayer;
    }

    public boolean isSelectedChildOfRoot(){
        if (LayersData.getInstance().getCurrentLayer() == null || rootLayer.getTreeItem() == null){
            return false;
        }
        if (LayersData.getInstance().getCurrentLayer().getTreeItem().equals(rootLayer.getTreeItem())){
            return false;
        }
        else{
            return true;
        }
    }

}
