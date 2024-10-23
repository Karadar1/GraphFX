package components;

import graph_classes.Graph;
import graph_classes.Output;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FilePrompt {

    private File selectedFile;

    // Method to open the FileChooser and select a file
    public void chooseFile(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Graph Node File");

        // Set file extension filters (e.g., text files)
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );

        // Show the file chooser and store the selected file
        selectedFile = fileChooser.showOpenDialog(stage);
    }

    // Method to read the file and build the graph from its contents
    public void readFileAndBuildGraph(Graph graph) {
        if (selectedFile == null) {
            System.out.println("No file selected.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] nodes = line.split(" ");
                if (nodes.length == 2) {
                    try {
                        int node1 = Integer.parseInt(nodes[0].trim());
                        int node2 = Integer.parseInt(nodes[1].trim());

                        // Add both nodes and the edge to the graph
                        graph.addVertex(node1);
                        graph.addVertex(node2);
                        graph.addEdge(node1, node2);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number format in file: " + line);
                    }
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }

            // Print the graph information using Output class
            Output output = new Output();
            System.out.println(output.countNodes(graph));
            output.printNeighbors(graph);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getter for the selected file (optional)
    public File getSelectedFile() {
        return selectedFile;
    }
}
