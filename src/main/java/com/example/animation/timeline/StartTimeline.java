package com.example.animation.timeline;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class StartTimeline {
    public HBox startTimeline(){


        HBox contentBox = new HBox();
        Line line = new Line(-100.41410827636719, 60.585784912109375, -100.41421508789062, 34.29289245605469);
        line.setStroke(Color.web("#0060ff")); // Set line color
        contentBox.getChildren().add(line);
        //contentBox.getChildren().add(treeView); // Add nodes to HBox
        for (int i = 0; i < 30; i ++){
            Button button = new Button();
            button.setId(String.valueOf(i));
            button.setOnAction(this::keyframe);
            contentBox.getChildren().add(button);
        }

        // Create a ScrollPane and set the HBox as its content
        return contentBox;
    }

    private void keyframe(ActionEvent actionEvent) {
        Button clickedButton = (Button) actionEvent.getSource();
        String buttonId = clickedButton.getId();
        System.out.println("Button ID: " + buttonId);
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

}
