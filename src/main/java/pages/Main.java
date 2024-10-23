package pages;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import components.InputPrompt;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        App app = new App();
        app.start(primaryStage);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
