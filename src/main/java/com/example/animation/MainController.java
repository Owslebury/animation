package com.example.animation;

import com.example.animation.controller.HelloController;
import com.example.animation.toolbox.ToolboxController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
This class passes the controllers to other controllers so that they are able to communicate while being decoupled.
 */
public class MainController implements Initializable {

    @FXML
    private ToolboxController toolboxController;

    @FXML
    private HelloController helloController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Pass the HelloController instance to ToolboxController
        //toolboxController.setHelloController(helloController);
    }
}

