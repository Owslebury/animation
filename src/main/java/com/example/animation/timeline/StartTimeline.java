package com.example.animation.timeline;

import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;

public class StartTimeline {
    public HBox startTimeline(){
        // Create a root node for the TreeView
        TreeItem<String> rootNode = new TreeItem<>("Root");

        // Create sample child nodes
        TreeItem<String> child1 = new TreeItem<>("Child 1");
        TreeItem<String> child2 = new TreeItem<>("Child 2");

        // Add child nodes to the root node
        rootNode.getChildren().addAll(child1, child2);

        // Create the TreeView with the root node
        TreeView<String> treeView = new TreeView<>(rootNode);

        HBox contentBox = new HBox();
        contentBox.getChildren().add(treeView); // Add nodes to HBox
        for (int i = 0; i < 30; i ++){
            Button button = new Button();
            contentBox.getChildren().add(button);
        }

        // Create a ScrollPane and set the HBox as its content
        return contentBox;
    }
}
