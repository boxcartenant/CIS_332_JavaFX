package my_new_package;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SceneThree implements Initializable {
    @FXML
    public Label UserNameLabel;
    @FXML
    public Label MacCoolLabel;
    @FXML
    TextField CSSTextField;
    @FXML
    public AnchorPane pain;
    @FXML
    TextField PieChartTextField;

    @FXML
    PieChart WordPieChart;

    SingletonDemo myData = SingletonDemo.getInstance();

    @FXML
    public void switchToScene1(ActionEvent event) throws IOException {
        myData.openScene(event, "SceneOne.fxml", "Scene 1 - Welcome");

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
        String input = PieChartTextField.getText();

        if (!input.isEmpty()) {
            double weight = input.length();
            PieChart.Data mydata = new PieChart.Data(input, weight);
            WordPieChart.getData().add(mydata);
            PieChartTextField.clear();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myData.set_common(pain, MacCoolLabel, UserNameLabel);
    }
}
