package my_new_package;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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

    SingletonDemo myData = SingletonDemo.getInstance();

    @FXML
    public void changeUsername(ActionEvent actionEvent) {
    }
    @FXML
    public void handleRadioSelection(ActionEvent actionEvent) {
    }
    @FXML
    public void changeBGColor(ActionEvent actionEvent) {
    }
    @FXML
    public void changeTextColor(ActionEvent actionEvent) {
    }
    @FXML
    public void toggleHonorifics(ActionEvent actionEvent) {
    }
    @FXML
    public void navigateScene1(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        refreshUI();
    }

    private void refreshUI() {
        //initialize selection from
    }
}
