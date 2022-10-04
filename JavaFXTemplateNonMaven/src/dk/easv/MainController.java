package dk.easv;

// Java imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

// Project imports


public class MainController implements Initializable {

    @FXML
    private Label lblHelloWorld;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Any initialization
    }

    /**
     * Event Handler - fires when btnStart is clicked
     * @param actionEvent
     */
    @FXML
    private void onClick(ActionEvent actionEvent) {
        lblHelloWorld.setText("Hello! I'm a basic JavaFX Starter Template");
        // Implement me....
    }
}
