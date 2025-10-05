package dk.easv.questionairemaven;

// Java imports
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Project imports


public class Main extends Application {

    /**
     * Entry point of the application
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(); // will call start() below
    }

    /**
     * Start the main FXML window
     * @param startStage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     * @throws Exception
     */
    @Override
    public void start(Stage startStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MainView.fxml"));
        Parent root = loader.load();
        startStage.setScene(new Scene(root));
        startStage.show();
    }
}