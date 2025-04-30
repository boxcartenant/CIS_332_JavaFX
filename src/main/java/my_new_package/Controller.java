package my_new_package;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    SingletonDemo myData = SingletonDemo.getInstance();
    @FXML
    public AnchorPane pain;
    @FXML
    public Label UserNameLabel;
    @FXML
    public Label MacCoolLabel;

    @FXML
    private Button switchButton;

    @FXML
    private Button switchBackButton;

    @FXML
    public void switchToScene3(ActionEvent event) throws IOException {
        myData.openScene(event, "SceneThree.fxml", "Scene 3 - Howdy");
    }

    @FXML
    public void switchToScene2(ActionEvent event) throws IOException {
        myData.openScene(event, "SceneTwo.fxml", "Scene 2 - Hello");
        myData.set_common(pain, MacCoolLabel, UserNameLabel);
    }

    @FXML
    public void switchToScene1(ActionEvent event) throws IOException {
        Stage scene1stage = myData.openScene(event, "SceneOne.fxml", "Scene 1 - Welcome");
        myData.set_common(pain, MacCoolLabel, UserNameLabel);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myData.set_common(pain, MacCoolLabel, UserNameLabel);
    }

    public void switchToSettings(ActionEvent event) throws IOException {
        Stage scene1stage = myData.openScene(event, "SettingsScene.fxml", "Some Settings!");
    }
}
