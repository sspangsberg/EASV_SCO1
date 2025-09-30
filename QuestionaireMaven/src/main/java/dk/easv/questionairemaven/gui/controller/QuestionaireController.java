package dk.easv.questionairemaven.gui.controller;

// Java imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


public class QuestionaireController {

    private String name;
    private MainWindowController parent;

    @FXML
    private Label lblName, lblScoreVal;

    @FXML
    private ToggleGroup q1,q2,q3,q4,q5,q6,q7,q8,q9;


    /**
     * Event handler that calculates the score based on an array of ToggleGroups
     * @param actionEvent
     */
    @FXML
    private void btnCalculateScore(ActionEvent actionEvent) {
        int score = calculateScore();

        //mainController.setScore(score); // set our main window
        lblScoreVal.setText(Double.toString(score)); // set this window
    }



    /**
     * Closes the window
     * @param actionEvent
     */
    @FXML
    private void close(ActionEvent actionEvent) {

        if (actionEvent.getSource() instanceof Node) {
            Node n = (Node) actionEvent.getSource();
            Stage parent = (Stage) n.getScene().getWindow();

            parent.close();
        }
    }

    /**
     * Sets the parent controller, so we have a handle
     * @param parent
     */
    public void setParentController(MainWindowController parent) {
        this.parent = parent;
    }


    /**
     * Sets the name of the participant
     * @param name
     */
    public void setName(String name) {
        this.name = name;
        lblName.setText("Name of participant: " + name);
    }


    /**
     * Calculate the score and update windows
     */
    private int calculateScore() {

        // create array of toggle groups (groups of radiobuttons)
        ToggleGroup[] questions = {q1,q2,q3,q4,q5,q6,q7,q8,q9};

        int score = 0; // create local variable to hold score

        // iterate through lists of questions (ToggleGroups)
        for (ToggleGroup question : questions) {
            RadioButton selectedRadioButton = (RadioButton) question.getSelectedToggle();

            // make sure it is not null
            if (selectedRadioButton != null) {
                String toggleGroupValue = selectedRadioButton.getText();

                if (toggleGroupValue.equals("Disagree"))
                    score--;
                else if (toggleGroupValue.equals("Agree"))
                    score++;
            }
        }

        return score;
    }



    @FXML
    private void btnSaveScore(ActionEvent actionEvent) {
        int score = calculateScore();
        this.parent.setData(name, score);
    }
}
