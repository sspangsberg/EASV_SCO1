package dk.questionaire.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class QuestionaireController {

    private int score = 0;
    MainWindowController mainController;

    @FXML
    private Label lblName;

    @FXML
    private void calculateScore(ActionEvent actionEvent) {
        // calculate the score
        score = 42; //fixme
    }

    @FXML
    private void close(ActionEvent actionEvent) {
        // transfer score to mainWindow
       Stage parent = (Stage) lblName.getScene().getWindow();

       mainController.setScore(score);
       parent.close();
    }

    public void setParentController(MainWindowController controller) {
        mainController = controller;
    }
}
