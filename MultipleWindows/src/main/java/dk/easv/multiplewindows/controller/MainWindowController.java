package dk.easv.multiplewindows.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindowController {
    @FXML
    private Label welcomeText;

    /**
     *
     * @throws IOException
     */
    @FXML
    protected void onHelloButtonClick() throws IOException {

        // Same loader logics as in MainApp.java
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Window1.fxml"));

        Parent scene = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(scene));

        // Set the modality to Application (you must close Window1 before going to the parent window
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
}