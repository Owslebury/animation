package com.example.animation.toolbox;

import com.example.animation.controller.CanvasController;
import com.example.animation.data.ToolData;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ToolboxController {
    private CanvasController canvasController;

    @FXML
    private Button editButton;

    public void setCanvasController(CanvasController canvasController) {
        this.canvasController = canvasController;
    }

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
            ToolData.getInstance().setToolmode(Toolmode.NONE);
        } else {
            button.setStyle("-fx-background-color: goldenrod;");
            lastPressedButton = button;
        }
    }

    @FXML
    private void edit() {
        handleButtonAction(editButton);
        ToolData.getInstance().setToolmode(Toolmode.DRAW);
    }

    @FXML
    private void fill() {
        handleButtonAction(fillButton);
        ToolData.getInstance().setToolmode(Toolmode.FILL);
    }

    @FXML
    private void scale() {
        handleButtonAction(scaleButton);
        ToolData.getInstance().setToolmode(Toolmode.SCALE);
    }

    @FXML
    private void select() {
        handleButtonAction(selectButton);
        ToolData.getInstance().setToolmode(Toolmode.SELECT);
    }
}
