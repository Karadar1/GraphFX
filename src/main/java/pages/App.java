package pages;

import components.FilePrompt;
import components.InputPrompt;
import graph_classes.Game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    private String numberOfNodes;  // To store the input from InputPrompt

    @Override
    public void start(Stage primaryStage) {
        // Create a button that will open the input prompt
        Button openInputPromptButton = new Button("Enter number of nodes");
        Button openFilePromptButton = new Button("Enter file");

        // Set the button action to open the input prompt in a new scene
        openInputPromptButton.setOnAction(event -> {
            InputPrompt inputPrompt = new InputPrompt();
            Stage inputStage = new Stage();

            // Show the input prompt
            inputPrompt.start(inputStage);

            // Set an action to run when the input stage is closed
            inputStage.setOnHiding(e -> {
                // Retrieve the input from the InputPrompt instance
                numberOfNodes = inputPrompt.getUserInput();
                System.out.println("Number of nodes: " + numberOfNodes);  // For demonstration
                // You can now use numberOfNodes to further process or create the graph
                try {
                    int nodes = Integer.parseInt(numberOfNodes);  // Will throw an exception
                    Game game = new Game(getNumberOfNodes());
                    game.start();

                } catch (NumberFormatException error) {
                    System.out.println("Invalid input: " + error.getMessage());
                }
            });
        });

        openFilePromptButton.setOnAction(event -> {
            FilePrompt filePrompt = new FilePrompt();
            Stage filePromptStage = new Stage();

            // Show the input prompt
            filePrompt.chooseFile(filePromptStage);

            // Set an action to run when the input stage is closed

        });

        // Create a VBox to stack the buttons vertically
        VBox vbox = new VBox(10);  // 10px spacing between buttons
        vbox.getChildren().addAll(openInputPromptButton, openFilePromptButton);

        // Create a scene for the VBox layout
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setTitle("Graph Node Input");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Getter for numberOfNodes (optional if you need it)
    public int getNumberOfNodes() {
        return Integer.parseInt(numberOfNodes);
    }
}
