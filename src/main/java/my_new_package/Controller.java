package my_new_package;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    // ------------------------ all code for scene abc here

    //..........

    SingletonDemo mySingleton = SingletonDemo.getInstance();

    @FXML
    private Button switchButton;

    @FXML
    private Button switchBackButton;

    @FXML
    public void switchToScene1(ActionEvent event) throws IOException {
        mySingleton.switchScenes(event, "SceneOne.fxml","Scene 1 - Welcome!");
    }
    @FXML
    public void switchToScene2(ActionEvent event) throws IOException {
        mySingleton.switchScenes(event, "SceneTwo.fxml","Scene 2 - Hello!");
    }

    @FXML
    public void switchToScene3(ActionEvent event) throws IOException {
        mySingleton.switchScenes(event, "SceneThree.fxml","Scene 3 - Whoa!");
    }



}
