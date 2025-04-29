package my_new_package;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SceneThree implements Initializable {


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

    // Utility method to sanitize CSS string
    private String encodeCss(String css) {
        return css.replace("\n", "").replace("\r", "").replace("\t", "");
    }

    @FXML
    TextField CSSInput;

    @FXML
    PieChart MyPieChart;

    @FXML
    TextField PieChartInput;

    @FXML
    public void switchToScene1(ActionEvent event) throws IOException {
        myData.switchScenes(event, "SceneOne.fxml","Scene 1 - Welcome!");
    }

    @FXML
    public void changeMyCSS(ActionEvent event) throws IOException {
        //try #rootPane { -fx-background-color: lightblue;}
        //or maybe .CSSInput { -fx-background-color: green;}
        //or maybe .greenStuff { -fx-background-color: green;}
        String newCSS = CSSInput.getText();
        System.out.println(newCSS);
        Scene thisScene = ((Node) event.getSource()).getScene();
        thisScene.getStylesheets().add("data:text/css," + encodeCss(newCSS));
    }


    @FXML
    public void addToPieChart(ActionEvent event) throws IOException {
        // Get the input string from PieChartInput
        String input = PieChartInput.getText();

        // Only add if the input is not empty
        if (!input.isEmpty()) {
            // Weight is the length of the string
            double weight = input.length();

            // Create a new PieChart.Data entry with the string and its weight
            PieChart.Data data = new PieChart.Data(input, weight);

            // Add the data to the pie chart
            MyPieChart.getData().add(data);

            // Optional: Clear the input field after adding
            PieChartInput.clear();
        }
    }
}

