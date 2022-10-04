package dk.easv.javafxstringexercises;

//Java imports
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application
{
    public static void main(String[] args)
    {
        //JavaFX version
        Application.launch();


        //Console Version (using Scanner)
        //Create object from class (using constructor)
        //StringUtilities strUtil = new StringUtilities();

        //Calling member function (method)
        //strUtil.addTagsToTextConsole();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gui/MainWindow.fxml"));
        Parent root = loader.load();

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}