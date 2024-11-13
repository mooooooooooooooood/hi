package DSA.tut11;

import java.util.*;

public class GraphLabeling {
    private static int n = 9; // Number of vertices

    // Depth-First Search to identify connected components and assign labels
    private static void DFS(int[][] graph, int vertex, char label, char[] labels) {
        labels[vertex] = label; // Assign label to the current vertex
        for (int i = 0; i < n; i++) {
            if (graph[vertex][i] == 1 && labels[i] == 0) {
                DFS(graph, i, label, labels); // Explore adjacent vertices
            }
        }
    }

    // Function to assign labels to the vertices of the graph
    public static char[] assignLabels(int[][] graph) {
        char[] labels = new char[n]; // Array to store labels
        Arrays.fill(labels, (char)0); // Initialize labels to 0 (unassigned)

        char currentLabel = 'A'; // Start labeling from 'A'

        for (int i = 0; i < n; i++) {
            if (labels[i] == 0) {
                // Explore the connected component starting from vertex i
                DFS(graph, i, currentLabel, labels);
                currentLabel++; // Move to the next label for the next connected component
            }
        }

        return labels;
    }

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                {0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0}
        };

        char[] vertexLabels = assignLabels(adjacencyMatrix);

        // Display assigned labels for each vertex
        System.out.println("Vertex Labels:");
        for (int i = 0; i < n; i++) {
            System.out.println("V" + i + ": " + vertexLabels[i]);
        }
    }
}

