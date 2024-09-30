package dk.easv.multiplewindows.controller;

// AWT no-go, always choose javafx
// Java imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class Window1Controller {

    // Instance variable that holds a reference
    // to the main window controller (parent)
    private MainWindowController parent;

    // Instance variables to JavaFX UI controls
    @FXML
    private TextField txtName;

    /**
     * Event handler method
     * Will be activated when the user presses the button
     * @param actionEvent
     */
    @FXML
    private void onButtonClick(ActionEvent actionEvent) {
        // Get data from UI - TextField
        String nameFromTextField = txtName.getText();

        // Call MainWindowController + setName()
        parent.setName(nameFromTextField);

        // shorter version (you can remove line 18 + 21)
        // parent.setName(txtName.getText());
    }

    /**
     * Sets a reference to the main window controller (parent window)
     * @param parentParam
     */
    public void setParent(MainWindowController parentParam) {
        this.parent = parentParam;
    }
}
