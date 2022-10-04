package dk.easv.javafxstringexercises.gui;

// Java imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

// Project imports
import dk.easv.javafxstringexercises.bll.StringUtilities;


public class MainController implements Initializable {

    @FXML
    private ComboBox cmbExercises;
    @FXML
    private TextField txtOutput;
    @FXML
    private TextField txtInput;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Load exercises into combobox
        cmbExercises.getItems().add("Surround with tags");
        cmbExercises.getItems().add("Count characters");
        // Add more exercises... :)
    }

    /**
     * Event Handler - fires when btnStart is clicked
     * @param actionEvent
     */
    @FXML
    private void onClick(ActionEvent actionEvent) {
        // Create utility object from class (using constructor)
        StringUtilities strUtil = new StringUtilities();

        // Get the selected index from the combobox (0,1,2,....)
        int selectedIndex = cmbExercises.getSelectionModel().getSelectedIndex();

        // Prepare helper variables
        String output = "";
        String input = txtInput.getText();

        if (selectedIndex == 0) {
            output = strUtil.addAtSign(input);
        }
        if (selectedIndex == 1) {
            output = strUtil.countCharacters(input) + "";
        }

        txtOutput.setText(output);
    }
}
