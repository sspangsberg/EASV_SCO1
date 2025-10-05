package dk.easv.questionairemaven.gui.controller;

// Java imports
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
import java.util.ArrayList;
import java.util.List;


public class MainController {

    @FXML
    private TextField txtName;
    @FXML
    private ListView<String> lvParticipants;

    @FXML
    private void btnClickFillQuestionaire(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/QuestionaireView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();

        // ref to the questionaire controller
        QuestionnaireController controller = loader.getController();
        controller.setName(txtName.getText());
        controller.setParent(this);

        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    /**
     * Set score and update the listview
     * @param score
     */
    protected void setScore(int score) {
        String name = txtName.getText();
        List<String> items = new ArrayList<>(lvParticipants.getItems().stream().toList());
        boolean hasUpdatedExisting = false;

        for (int i = 0; i < items.size(); i++) {
            String participant = items.get(i);

            if (participant.contains(name)) { // we found a match
                items.set(i,name + " : " + score); // modify match with new score
                hasUpdatedExisting = true;
                break;
            }
        }
        lvParticipants.getItems().clear();
        lvParticipants.getItems().addAll(items);


        if (!hasUpdatedExisting) // we have no match to update. create a new entry
        {
            lvParticipants.getItems().add(name + " : " + score);
        }
    }
}
