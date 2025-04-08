package com.example.javafx_class_1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {

    int button_state = 0;

    @FXML
    private Label welcomeText;

    @FXML
    private Button myButton;

    @FXML
    protected void onHelloButtonClick() {
        if (button_state == 0) {
            myButton.setStyle("-fx-background-color: green");
            button_state = 1;
        }
        else if (button_state == 1) {
            myButton.setStyle("-fx-background-color: blue");
            button_state = 0;
        }

        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
