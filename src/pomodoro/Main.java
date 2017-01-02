package pomodoro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main-window.fxml"));
        Font.loadFont(getClass().getResource("/fonts/Ewert-Regular.ttf").toExternalForm(),10.0);
        Font.loadFont(getClass().getResource("/fonts/VarelaRound-Regular.ttf").toExternalForm(),10.0);
        primaryStage.setTitle("Pomodoro Application");
        primaryStage.setScene(new Scene(root, 500.0, 500.0));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
