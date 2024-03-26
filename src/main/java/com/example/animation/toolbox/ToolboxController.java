package com.example.animation.toolbox;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;

public class ToolboxController {

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private Button editButton;

    @FXML
    private Button fillButton;

    @FXML
    private Button scaleButton;

    @FXML
    private Button selectButton;

    @FXML
    public void initialize() {
        // Initialization code, if needed
    }

    @FXML
    private void edit() {
        // Handle edit button action
        System.out.println("Edit button clicked");
    }

    // Add more methods as needed for other button actions or event handlers
}
