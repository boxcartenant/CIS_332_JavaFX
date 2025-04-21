package my_new_package;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SingletonDemo {
    //create a single static instance of the class
    private static final SingletonDemo instance = new SingletonDemo();

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
}
