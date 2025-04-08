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

    @FXML
    private Button switchButton;

    @FXML
    private Button switchBackButton;

    @FXML
    public void switchToScene2(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("SceneTwo.fxml"));
        Scene scene2 = new Scene(fxmlLoader.load(), 600,400);

        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();

        stage.setTitle("Scene 2 - Hello");
        stage.setScene(scene2);
        stage.show();
    }

    @FXML
    public void switchToScene1(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("SceneOne.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 600, 400);

        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();

        stage.setTitle("Scene 1 - Welcome");
        stage.setScene(scene1);
        stage.show();
    }

}
