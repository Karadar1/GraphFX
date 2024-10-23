package components;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InputPrompt {

    private String userInput;  // Variable to store the user input

    public void start(Stage inputStage) {
        // Create a label for the input prompt
        Label promptLabel = new Label("Enter a number of nodes between 5 and 10");

        // Create a TextField for input
        TextField nodeInput = new TextField();
        nodeInput.setPromptText("Enter a number of nodes between 5 and 10");

        // Create a button to submit the input
        Button submitButton = new Button("Submit");

        // Add an action listener to the submit button
        submitButton.setOnAction(event -> {
            // Capture the input and store it in the userInput variable
            userInput = nodeInput.getText();

            // Close the input stage after submission
            inputStage.close();
        });

        // Create the layout for the input prompt window
        VBox layout = new VBox(10);
        layout.getChildren().addAll(promptLabel, nodeInput, submitButton);

        // Create a new scene with this layout
        Scene scene = new Scene(layout, 300, 150);
        inputStage.setTitle("Node Input");
        inputStage.setScene(scene);
        inputStage.show();
    }

    // Method to get the user input after submission
    public String getUserInput() {
        return userInput;
    }
}
