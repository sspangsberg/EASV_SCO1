package dk.easv.questionairemaven.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class MainWindowController {

    @FXML
    private TextField txtName;
    @FXML
    private ListView lvParticipants;

    /**
     * Event handler that fires off when a new questionaire is filled out
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    private void btnFillQuestionaire(ActionEvent actionEvent) throws IOException {

        // Open questionaire window
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/QuestionaireWindow.fxml"));

        Parent scene = loader.load();
        Stage stage = new Stage();

        // Get the controller, so we can give it a reference to the main controller (this)
        QuestionaireController controller = loader.getController();
        controller.setParentController(this);
        controller.setName(txtName.getText());

        stage.setTitle("Questionaire Fillout");
        stage.setScene(new Scene(scene));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }


    /**
     * Setter for the score, when a questionaire has been filled out
     * @param name
     * @param score
     */
    public void setData(String name, int score) {
        lvParticipants.getItems().add(name + " : " + score);
    }
}
