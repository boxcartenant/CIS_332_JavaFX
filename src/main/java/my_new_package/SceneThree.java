package my_new_package;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneThree {
    @FXML
    TextField CSSTextField;

    @FXML
    TextField PieChartTextField;

    @FXML
    PieChart WordPieChart;

    SingletonDemo mySingleton = SingletonDemo.getInstance();

    @FXML
    public void switchToScene1(ActionEvent event) throws IOException {
        mySingleton.openScene(event, "SceneOne.fxml", "Scene 1 - Welcome!");
    }

    @FXML
    public void changeMyCSS(ActionEvent event) throws IOException {
        String newCSS = CSSTextField.getText();
        System.out.println(newCSS);
        Scene thisScene = ((Node)event.getSource()).getScene();
        thisScene.getStylesheets().add("data:text/css," + newCSS);
    }

    @FXML
    public void addToPieChart(ActionEvent event) throws IOException {
        System.out.println("Not yet implemented");
    }


}
