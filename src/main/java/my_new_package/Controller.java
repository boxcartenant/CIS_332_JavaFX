package my_new_package;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    // ------------------------ all code for scene abc here

    //..........

    SingletonDemo myData = SingletonDemo.getInstance();
    @FXML
    public Label CurrentUser;
    @FXML
    public Label MacCoolOut;
    @FXML
    public AnchorPane pain;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //initialize common components
        myData.set_common(pain, MacCoolOut, CurrentUser);
    }

    @FXML
    private Button switchButton;

    @FXML
    private Button switchBackButton;

    @FXML
    public void switchToScene1(ActionEvent event) throws IOException {
        myData.switchScenes(event, "SceneOne.fxml","Scene 1 - Welcome!");
    }
    @FXML
    public void switchToScene2(ActionEvent event) throws IOException {
        myData.switchScenes(event, "SceneTwo.fxml","Scene 2 - Hello!");
    }

    @FXML
    public void switchToScene3(ActionEvent event) throws IOException {
        myData.switchScenes(event, "SceneThree.fxml","Scene 3 - Whoa!");
    }


    public void switchToSettings(ActionEvent event) throws IOException {
        myData.switchScenes(event, "SettingsScene.fxml","Settings");
    }
}
