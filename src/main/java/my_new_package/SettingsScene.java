package my_new_package;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsScene implements Initializable {
    @FXML
    public ColorPicker bgcolor;
    @FXML
    public TextField username;
    @FXML
    public RadioButton noRadio;
    @FXML
    public ToggleGroup Macintoggle;
    @FXML
    public RadioButton unknownRadio;
    @FXML
    public RadioButton yesRadio;
    @FXML
    public CheckBox honorifics;
    @FXML
    public Label CurrentUser;
    @FXML
    public Label MacCoolOut;
    @FXML
    public AnchorPane pain;
    @FXML
    public ColorPicker TextColor;

    SingletonDemo myData = SingletonDemo.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        refreshUI();
    }

    private void refreshUI() {
        //initialize selection from UserData (optional)
        if (myData.macCoolInt == 0) unknownRadio.setSelected(true);
        else if (myData.macCoolInt == -1) noRadio.setSelected(true);
        else if (myData.macCoolInt == 1) yesRadio.setSelected(true);
        else unknownRadio.setSelected(true);

        //initialize background color and username
        if (myData.textColor != null) TextColor.setValue(myData.textColor);
        if (myData.bgColor != null) bgcolor.setValue(myData.bgColor);
        if (myData.userName != null) username.setText(myData.userName);

        // Initialize honorifics checkbox
        honorifics.setSelected(myData.honorifics);

        //initialize common components
        myData.set_common(pain, MacCoolOut, CurrentUser);
    }

    @FXML
    private void handleRadioSelection(ActionEvent event) {
        //get the source RadioButton
        RadioButton selected = (RadioButton) event.getSource();
        if (selected.isSelected()) { //ensure it's selected
            String selectedText = selected.getText();
            switch (selectedText) {
                case "Unknown":
                    myData.isMacCool = "We don't know if mac is cool or not.";
                    myData.macCoolInt = 0;
                    break;
                case "No":
                    myData.isMacCool = "Mac is not cool.";
                    myData.macCoolInt = -1;
                    break;
                case "Yes":
                    myData.isMacCool = "Mac is cool.";
                    myData.macCoolInt = 1;
                    break;
            }
        }
        refreshUI();
    }

    @FXML
    public void navigateScene1(ActionEvent event) throws IOException {
        myData.switchScenes(event, "SceneOne.fxml","Scene 1 - Welcome!");
    }

    @FXML
    public void changeBgColor(ActionEvent actionEvent) {
        myData.bgColor = bgcolor.getValue();
        refreshUI();
    }

    @FXML
    public void changeUsername(ActionEvent actionEvent) {
        myData.userName = username.getText();
        refreshUI();
    }
    @FXML
    public void toggleHonorifics(ActionEvent actionEvent) {
        myData.honorifics = honorifics.isSelected();
        refreshUI();
    }

    public void changeTextColor(ActionEvent actionEvent) {
        myData.textColor = TextColor.getValue();
        refreshUI();
    }
}
