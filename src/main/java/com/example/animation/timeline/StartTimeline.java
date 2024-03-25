package com.example.animation.timeline;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.HBox;

public class StartTimeline {
    public HBox startTimeline(){


        HBox contentBox = new HBox();
        //contentBox.getChildren().add(treeView); // Add nodes to HBox
        for (int i = 0; i < 30; i ++){
            Button button = new Button();
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    keyframe();
                }
            });
            contentBox.getChildren().add(button);
        }

        // Create a ScrollPane and set the HBox as its content
        return contentBox;
    }
    public TreeItem<String> initializeLayers(){
        TreeItem<String> rootNode = new TreeItem<>("Root Node");
        rootNode.setExpanded(true); // Optional: Expand root node by default

        TreeItem<String> childNode1 = new TreeItem<>("Child Node 1");
        TreeItem<String> childNode2 = new TreeItem<>("Child Node 2");

        // Add children nodes to the root node
        rootNode.getChildren().addAll(childNode1, childNode2);

        // Set the root node to the TreeView
        return rootNode;
    }
    public void keyframe(){
        System.out.println("ergrg");
    }
}
