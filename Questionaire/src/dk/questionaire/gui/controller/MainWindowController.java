package dk.questionaire.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class MainWindowController {

    private int score;

    @FXML
    private TextField txtName;
    @FXML
    private Label lblScore, lblName, lblText;

    /**
     * Event handler that fires off when a new questionaire is filled out
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    private void fillQuestionaire(ActionEvent actionEvent) throws IOException {

        // Open questionaire window
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/QuestionaireWindow.fxml"));
        Parent scene = loader.load();
        Stage stage = new Stage();

        // Get the controller, so we can give it a reference to the main controller (this)
        QuestionaireController controller = loader.getController();
        controller.setParentController(this);

        stage.setTitle("Questionaire Fillout");
        stage.setScene(new Scene(scene));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }


    /**
     * Setter for the score, when a questionaire has been filled out
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
        lblScore.setText(Integer.toString(score));
    }
}
