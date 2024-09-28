package dk.easv.multiplewindows;

// Java imports
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApp extends Application {

    /**
     * @param stage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     *
     * Application: Is a single instance which creates the environment for you.
     *              It creates a stage and launches the javafx UI thread.
     *
     * Stage:       Is a window. You can have as many Stages as you want. Application
     *              provides you with a Stage in the start method, which has some
     *              special properties, compared to manually created Stages.
     *
     * Scene:       Every Stage can hold exactly one Scene at a time.
     *
     * Parent:      A simple Node that can hold other Nodes as children. Every Scene
     *              needs exactly one Parent as the root.
     *
     * FXML:        Has nothing to do with anything above.
     *
     * A single FXML file just describes the hierarchy of a Node (the root node that you
     * get of the FXMLLoader) and it's children. You can have a FXML file describe a single
     * Button or the root Node of a Scene and all its children. FXML is not bound to a single Scene.
     *
     * If you want you can have the FXML file describe a Label and a Textfield inside a
     * GridPane (like a standart input formular) and load it every time you need this
     * arrangement somewhere (as often as you want, even in a single Scene).
     *
     * https://stackoverflow.com/questions/39873287/what-is-the-relationship-between-java-fx-application-scene-and-parent
     *
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {

        // Create FXMLLoader object
        FXMLLoader loader = new FXMLLoader();

        // Set its location to point to an FXML file
        loader.setLocation(getClass().getResource("/MainWindow.fxml"));

        // Create parent node and tell the loader object to load the FXML file
        Parent scene = loader.load();

        // Instruct the stage to show a new scene with the contents of the FXML file
        stage.setScene(new Scene(scene));
        stage.show();

        /* IntelliJ auto-gen JavaFX code
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/MainWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        */
    }

    /**
     * Starting point of the Java application
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }
}