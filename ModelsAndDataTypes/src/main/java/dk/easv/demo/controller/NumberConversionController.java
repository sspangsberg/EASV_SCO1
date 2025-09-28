package dk.easv.demo.controller;

// Project imports
import dk.easv.demo.model.NumberConversionModel;

// Java imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class NumberConversionController implements Initializable {

    private NumberConversionModel ncModel = new NumberConversionModel();

    @FXML
    private Label lblWelcomeText;

    @FXML
    private TextField txtNumberInput;
    @FXML
    private Button btnCalcMilesToKm;
    @FXML
    private Label lblResult;

    /**
     *
     * @param url
     * The location used to resolve relative paths for the root object, or
     * {@code null} if the location is not known.
     *
     * @param rb
     * The resources used to localize the root object, or {@code null} if
     * the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TextInputDialog dialog = new TextInputDialog("");

        dialog.setTitle("Text Input Dialog");
        dialog.setContentText("Please enter your name:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            String message = ncModel.getGreetingsMessage(result.get());
            lblWelcomeText.setText(message);
        }
    }


    /**
     * Event handler
     * @param event
     */
    @FXML
    private void onClickKmToMiles(ActionEvent event)
    {
        double txtFieldValue = Double.parseDouble(txtNumberInput.getText());
        double result = ncModel.getMilesFromKilometers(txtFieldValue);
        //String resultInMiles = String.valueOf(result);
        String resultAsString = String.format("%.4f", result);
        lblResult.setText(resultAsString);
    }


    /**
     * Event handler
     * @param event
     */
    @FXML
    private void onClickMilesToKm(ActionEvent event)
    {
        double txtFieldValue = Double.parseDouble(txtNumberInput.getText());
        double result = ncModel.getKilometersFromMiles(txtFieldValue);
        String resultAsString = String.valueOf(result);
        lblResult.setText(resultAsString);
    }





    @FXML
    protected void onHelloButtonClick() {
        lblWelcomeText.setText("Welcome to JavaFX Application!");
    }

}
