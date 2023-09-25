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

    @FXML
    private Label lblScore;
    private int score;

    @FXML
    private TextField txtName;
    @FXML
    private Label lblName;
    @FXML
    private Label lblText;

    @FXML
    private void fillQuestionaire(ActionEvent actionEvent) throws IOException {
        // Open questionaire window
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/QuestionaireWindow.fxml"));
        Parent scene = loader.load();
        Stage stage = new Stage();
        QuestionaireController controller = loader.getController();
        controller.setParentController(this);

        stage.setTitle("Questionaire Fillout");
        stage.setScene(new Scene(scene));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }


    public void setScore(int score) {
        this.score = score;
        lblScore.setText(Integer.toString(score));
    }
}
