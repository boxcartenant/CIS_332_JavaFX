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
    public RadioButton RadioYes;
    @FXML
    public ToggleGroup MacCoolGroup;
    @FXML
    public RadioButton RadioUnknown;
    @FXML
    public RadioButton RadioNo;
    @FXML
    public ColorPicker BGColorPicker;
    @FXML
    public ColorPicker TextColorPicker;
    @FXML
    public CheckBox HonorificsCheckbox;
    @FXML
    public Button scene1Button;
    @FXML
    public TextField username;
    @FXML
    public AnchorPane pain;
    @FXML
    public Label UserNameLabel;
    @FXML
    public Label MacCoolLabel;

    SingletonDemo myData = SingletonDemo.getInstance();

    @FXML
    public void changeUsername(ActionEvent actionEvent) {
        myData.userName = username.getText();
        refreshUI();
    }
    @FXML
    public void handleRadioSelection(ActionEvent event) {
        //get the source radiovutton
        RadioButton selected = (RadioButton) event.getSource();
        if (selected.isSelected()) {
            String selectedText = selected.getText();
            switch (selectedText) {
                case "Don't Know":
                    myData.isMacCool = "We don't know if Mac is cool.";
                    myData.macCoolInt = 0;
                    break;
                case "No":
                    myData.isMacCool = "Mac is very uncool.";
                    myData.macCoolInt = -1;
                    break;
                case "Yes":
                    myData.isMacCool = "Mac is super cool.";
                    myData.macCoolInt = 1;
                    break;
            }
        }
        refreshUI();
    }
    @FXML
    public void changeBGColor(ActionEvent actionEvent) {
        myData.bgColor = BGColorPicker.getValue();
        refreshUI();
    }
    @FXML
    public void changeTextColor(ActionEvent actionEvent) {
        myData.textColor = TextColorPicker.getValue();
        refreshUI();
    }
    @FXML
    public void toggleHonorifics(ActionEvent actionEvent) {
        myData.honorifics = HonorificsCheckbox.isSelected();
        refreshUI();
    }
    @FXML
    public void navigateScene1(ActionEvent event) throws IOException {
        myData.openScene(event, "SceneOne.fxml", "Scene 1 - Welcome");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        refreshUI();
    }

    private void refreshUI() {
        //initialize selection from
        if (myData.macCoolInt == 0) RadioUnknown.setSelected(true);
        else if (myData.macCoolInt == -1) RadioNo.setSelected(true);
        else if (myData.macCoolInt == 1) RadioYes.setSelected(true);
        else RadioUnknown.setSelected(true);

        //initialize background color pickers and username entry
        if (myData.textColor != null) TextColorPicker.setValue(myData.textColor);
        if (myData.bgColor != null) BGColorPicker.setValue(myData.bgColor);
        if (myData.userName != null) username.setText(myData.userName);

        HonorificsCheckbox.setSelected(myData.honorifics);

        myData.set_common(pain, MacCoolLabel, UserNameLabel);
    }
}
