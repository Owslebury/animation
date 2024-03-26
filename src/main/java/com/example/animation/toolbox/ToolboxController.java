package com.example.animation.toolbox;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class ToolboxController {

    @FXML
    private Button editButton;

    @FXML
    private Button fillButton;

    @FXML
    private Button scaleButton;

    @FXML
    private Button selectButton;

    private Button lastPressedButton; // Keep track of the last pressed button

    @FXML
    public void initialize() {
        // Initialization code, if needed
    }

    @FXML
    private void handleButtonAction(Button button) {
        if (lastPressedButton != null && lastPressedButton != button) {
            lastPressedButton.setStyle("");
        }
        if (button.getStyle().contains("goldenrod")) {
            button.setStyle("");
            lastPressedButton = null;
        } else {
            button.setStyle("-fx-background-color: goldenrod;");
            lastPressedButton = button;
        }
    }

    @FXML
    private void edit() {
        handleButtonAction(editButton);
    }

    @FXML
    private void fill() {
        handleButtonAction(fillButton);
    }

    @FXML
    private void scale() {
        handleButtonAction(scaleButton);
    }

    @FXML
    private void select() {
        handleButtonAction(selectButton);
    }
}
