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

    SingletonDemo mySingleton = SingletonDemo.getInstance();

    @FXML
    private Button switchButton;

    @FXML
    private Button switchBackButton;

    @FXML
    public void switchToScene3(ActionEvent event) throws IOException {
        mySingleton.openScene(event, "SceneThree.fxml", "Scene 3 - Howdy");
    }

    @FXML
    public void switchToScene2(ActionEvent event) throws IOException {
        mySingleton.openScene(event, "SceneTwo.fxml", "Scene 2 - Hello");
    }

    @FXML
    public void switchToScene1(ActionEvent event) throws IOException {
        Stage scene1stage = mySingleton.openScene(event, "SceneOne.fxml", "Scene 1 - Welcome");

    }

}
