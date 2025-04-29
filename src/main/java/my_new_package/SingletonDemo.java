package my_new_package;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class SingletonDemo {
    //create a single static instance of the class
    private static final SingletonDemo instance = new SingletonDemo();

    public static String userName;
    public static boolean honorifics;
    public static String isMacCool;
    public static Color bgColor;
    public static Color buttonColor;
    public int macCoolInt;
    public Color textColor;

    private SillyTitleGenerator sillyTitleGenerator;

    //private constructor -- prevents instantiation from outside
    private SingletonDemo() {
        //prevent instantiation by reflection
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    //public method to get the instance
    public static SingletonDemo getInstance() { return instance;}

    //example method to demo functionality
    public void showMessage() { System.out.println("Hello from the Singleton!");}

    public void switchScenes(ActionEvent event, String resourceName, String pageTitle) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource(resourceName));
        Scene scene2 = new Scene(fxmlLoader.load(), 600,400);

        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();

        stage.setTitle(pageTitle);
        stage.setScene(scene2);
        stage.show();
    }

    public void set_common(AnchorPane pain, Label macCoolOut, Label currentUser) {
        //set background color from singleton
        if (this.bgColor != null) {
            String hexColor = String.format("#%02X%02X%02X",
                    (int) (this.bgColor.getRed() * 255),
                    (int) (this.bgColor.getGreen() * 255),
                    (int) (this.bgColor.getBlue() * 255));
            pain.setStyle("-fx-background-color: " + hexColor + ";");
        }

        //set MacCoolOut label text from singleton
        if (this.isMacCool != null) {
            macCoolOut.setText(this.isMacCool);
        } else {
            macCoolOut.setText("We don't know if Mac is cool or not.");
        }

        //set username from singleton
        if (this.userName != null) {
            if (this.honorifics) {
                currentUser.setText("Current User: " + sillyTitleGenerator.generateTitle(this.userName));
            } else {
                currentUser.setText("Current User: " + this.userName);
            }
        } else {
            currentUser.setText("Current User: SomeUser");
        }

        //set the text color for every text object
        if (this.textColor != null) {
            String hexTextColor = String.format("#%02X%02X%02X",
                    (int) (this.textColor.getRed() * 255),
                    (int) (this.textColor.getGreen() * 255),
                    (int) (this.textColor.getBlue() * 255));
            applyTextColor(pain, hexTextColor);
        }
    }

    //recurse through the pane and find all labels, buttons, etc... objects with text, and change them
    private void applyTextColor(Node node, String hexColor) {
        if (node instanceof Label || node instanceof Button || node instanceof RadioButton ||
                node instanceof CheckBox || node instanceof TextField || node instanceof Text) {
            node.setStyle(node.getStyle() + ";-fx-text-fill: " + hexColor + ";");
        }
        if (node instanceof javafx.scene.Parent) {
            for (Node child : ((javafx.scene.Parent) node).getChildrenUnmodifiable()) {
                applyTextColor(child, hexColor);
            }
        }
    }
}
