package dk.easv.questionairemaven.gui.controller;

import dk.easv.questionairemaven.gui.util.FXUtils;

// Java imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class QuestionaireController implements Initializable{

    private int score = 0;
    private String name;
    private MainWindowController parent;

    @FXML
    private VBox container;

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
     * Event handler for all radio buttons
     * @param actionEvent
     */
    @FXML
    private void handleInput(ActionEvent actionEvent) {
        //handleCalculateScore();
    }


    /**
     * Calculate the score and update windows
     */
    private int calculateScore() {

        ToggleGroup[] questions = {q1,q2,q3,q4,q5,q6,q7,q8,q9};

        score = 0; // calculate the score

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


    /**
     *
     * @param location
     * The location used to resolve relative paths for the root object, or
     * {@code null} if the location is not known.
     *
     * @param resources
     * The resources used to localize the root object, or {@code null} if
     * the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        List<RadioButton> rbList = FXUtils.getAllRadioButtons(container);

        // dynamically add the event handler to all RadioButtons
        for (RadioButton rb: rbList) {
            rb.setOnAction(this::handleInput);
        }
    }

    @FXML
    private void btnSaveScore(ActionEvent actionEvent) {
        this.parent.setData(name, calculateScore());
    }
}
