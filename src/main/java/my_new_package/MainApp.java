package my_new_package;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    // The stage is the main window of the javafx application
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("SceneOne.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 600, 400);

        primaryStage.setTitle("Scene 1 - Welcome");
        primaryStage.setScene(scene1);

        primaryStage.show();
    }

    public static void main(String[] args) {
        //Singleton stuff below here:
        SingletonDemo singleton = SingletonDemo.getInstance();

        singleton.showMessage();

        SingletonDemo anotherSingleton = SingletonDemo.getInstance();

        System.out.println("Same instance? " + (singleton == anotherSingleton));

        launch();
    }
}
