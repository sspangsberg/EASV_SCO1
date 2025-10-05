package dk.easv.questionairemaven.gui.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class QuestionnaireController {

    @FXML
    private Label lblName;

    @FXML
    private Label lblScoreVal;

    @FXML
    private ToggleGroup q1,q2,q3,q4,q5,q6,q7,q8,q9;

    private MainController parent;




    /**
     * Sets the name of the participant
     * @param inputName
     */
    public void setName(String inputName) {
        lblName.setText("Name of participant: " + inputName);
    }

    @FXML
    private void onBtnClickCalculate(ActionEvent actionEvent) {

        //calculate the score
        int score = calculateScore(); // call calculate method

        //print the result to the label
        lblScoreVal.setText(score + "");

    }

    //
    private int calculateScore() {

        // create an array of ToggleGroups
        ToggleGroup[] questions = { q1,q2,q3,q4,q5,q6,q7,q8,q9 };

        int score = 0; // local helper variable

        // iterate through the list
        for (ToggleGroup question: questions) {
            // make sure questions is not null
            if (question != null) {
                RadioButton rb = (RadioButton) question.getSelectedToggle();

                if (rb != null) {
                    String rbText = rb.getText();

                    if (rbText.equals("Disagree")) { score--; }
                    else if (rbText.equals("Agree")) { score++; }

                }
            }
        }

        return score;
    }

    @FXML
    private void onClickClose(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        Stage s = (Stage) node.getScene().getWindow();
        s.close();
    }

    protected void setParent(MainController mainController) {
        this.parent = mainController; // set a reference to parent controller
    }

    @FXML
    private void onClickSaveScore(ActionEvent actionEvent) {
        parent.setScore(calculateScore());
    }
}
