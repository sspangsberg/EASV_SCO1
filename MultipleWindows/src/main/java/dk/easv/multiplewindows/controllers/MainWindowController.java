package dk.easv.multiplewindows.controllers;

// imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import dk.easv.multiplewindows.Main;

import java.io.IOException;

public class MainWindowController {

    @FXML
    private TextField txtDataFromWindow1;
    @FXML
    private TextField txtName;

    /**
     * Button Event handler
     * @param actionEvent
     */
    @FXML
    private void btnOpenWindow1(ActionEvent actionEvent) throws IOException {

        // launch window #1
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/views/Window1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        Stage stage = new Stage();
        stage.setTitle("Window 1");
        stage.setScene(scene);
        //stage.initModality(Modality.APPLICATION_MODAL);

        // Get controller
        Window1Controller controller = fxmlLoader.getController();
        controller.setGreetingsText("Welcome to Window#1 " + txtName.getText());
        controller.setParent(this);

        stage.show();
    }

    /**
     *
     * @param actionEvent
     */
    @FXML
    private void btnOpenWindow2(ActionEvent actionEvent) throws IOException {

        // launch window #2
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/views/Window2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        Stage stage = new Stage();
        stage.setTitle("Window 2");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void setDataFromWindow1(String data) {
        txtDataFromWindow1.setText(data);
    }


}
