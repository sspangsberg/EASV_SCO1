package dk.questionaire.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class QuestionaireController {

    private int score = 0;
    private MainWindowController mainController;

    @FXML
    private Label lblName;

    @FXML
    private ToggleGroup q1,q2;


    /**
     * Event handler that calculates the score based on an array of ToggleGroups
     * @param actionEvent
     */
    @FXML
    private void calculateScore(ActionEvent actionEvent) {
        // calculate the score
        // info from the radio buttons
        ToggleGroup[] questions = {q1,q2};

        for (ToggleGroup question : questions) {
            RadioButton selectedRadioButton = (RadioButton) question.getSelectedToggle();
            String toggleGroupValue = selectedRadioButton.getText();

            if (toggleGroupValue.equals("Disagree"))
                score--;
            else if (toggleGroupValue.equals("Agree"))
                score++;
        }

        mainController.setScore(score);
    }

    /**
     * Closes the window
     * @param actionEvent
     */
    @FXML
    private void close(ActionEvent actionEvent) {
       //Stage parent = (Stage) lblName.getScene().getWindow();

       if (actionEvent.getSource() instanceof Node) {
           Node n = (Node) actionEvent.getSource();
           Stage parent = (Stage) n.getScene().getWindow();
           parent.close();
       }
    }

    /**
     * Sets the parent controller, so we have a handle
     * @param controller
     */
    public void setParentController(MainWindowController controller) {
        mainController = controller;
    }
}
