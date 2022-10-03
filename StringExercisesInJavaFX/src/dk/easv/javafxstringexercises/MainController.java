package dk.easv.javafxstringexercises;

//Java imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private ComboBox cmbExercises;
    @FXML
    private TextField txtOutput;
    @FXML
    private Button btnStart;
    @FXML
    private TextField txtInput;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Load exercises
        cmbExercises.getItems().add("Surround with tags");
        cmbExercises.getItems().add("Count characters");
    }

    /**
     * Event Handler - fires when btnStart is clicked
     * @param actionEvent
     */
    @FXML
    private void onClick(ActionEvent actionEvent) {
        //Create utility object from class (using constructor)
        StringUtilities strUtil = new StringUtilities();

        int selectedIndex = cmbExercises.getSelectionModel().getSelectedIndex();
        String output = "";
        String input = txtInput.getText();

        switch (selectedIndex) {
            case 0: //
                output = strUtil.addTagsToText(input);
                break;
            case 1:

                break;
            case 2:
                break;
            default:
                break;
        }

        txtOutput.setText(output);
    }
}
