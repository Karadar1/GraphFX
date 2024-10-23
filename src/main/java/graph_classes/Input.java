package graph_classes;

import graph_classes.Graph;
import graph_classes.Output;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Input {

    // Method to read the file and build the graph from the neighbor format
    public void readFileAndBuildGraph(File file, Graph graph) {
        if (file == null) {
            System.out.println("No file selected.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length > 1) {
                    try {
                        int node = Integer.parseInt(parts[0].trim());  // The first number is the node

                        // Add the node to the graph
                        graph.addVertex(node);

                        // The rest of the numbers are neighbors
                        for (int i = 1; i < parts.length; i++) {
                            int neighbor = Integer.parseInt(parts[i].trim());
                            graph.addVertex(neighbor);     // Add the neighbor to the graph if it doesn't exist
                            graph.addEdge(node, neighbor); // Add an edge between the node and its neighbor
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number format in file: " + line);
                    }
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }

            // Output the result using the Output class
            Output output = new Output();
            System.out.println(output.countNodes(graph));
            output.printNeighbors(graph);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
