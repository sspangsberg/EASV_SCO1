package dk.easv.multiplewindows.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Window1Controller {

    @FXML
    private Label lblGreetings;
    @FXML
    private TextField txtDataToMain;

    private MainWindowController mainWindowController;


    public void setGreetingsText(String name) {
        lblGreetings.setText(name);
    }

    @FXML
    private void handleSendDataToMain(ActionEvent actionEvent) {
        this.mainWindowController.setDataFromWindow1(txtDataToMain.getText());
    }

    public void setParent(MainWindowController mainWindowController) {
        this.mainWindowController = mainWindowController;
    }
}
