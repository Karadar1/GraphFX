package graph_classes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
    // Adjacency list: each vertex has a set of neighboring vertices
    private HashMap<Integer, Set<Integer>> adjacencyList;
    private int edgeNumber;
    private int vertexNumber;


    // Constructor
    public Graph(int vertexNumber ) {
        adjacencyList = new HashMap<>();
    }

    // Add a vertex to the graph
    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new HashSet<>());
    }

    // Add an edge between two vertices (undirected graph)
    public void addEdge(int vertex1, int vertex2) {
        adjacencyList.putIfAbsent(vertex1, new HashSet<>());
        adjacencyList.putIfAbsent(vertex2, new HashSet<>());
        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);  // For undirected graphs
    }

    // Getter to access the adjacency list
    public HashMap<Integer, Set<Integer>> getAdjacencyList() {
        return adjacencyList;
    }
}
