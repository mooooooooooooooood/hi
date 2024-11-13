package DSA.tut11;

import java.util.*;

public class TopologicalSort {
    private static int n = 8; // Number of vertices

    // Depth-First Search (DFS) to perform topological sorting
    private static void DFS(int[][] graph, int vertex, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;

        for (int i = 0; i < n; i++) {
            if (graph[vertex][i] == 1 && !visited[i]) {
                DFS(graph, i, visited, stack);
            }
        }

        stack.push(vertex); // Add vertex to stack after visiting all its adjacent vertices
    }

    // Function to perform topological sorting of the graph
    public static List<Integer> topologicalSort(int[][] graph) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFS(graph, i, visited, stack);
            }
        }

        List<Integer> topologicalOrder = new ArrayList<>();
        while (!stack.isEmpty()) {
            topologicalOrder.add(stack.pop());
        }

        return topologicalOrder;
    }

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                {0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };

        List<Integer> topologicalOrder = topologicalSort(adjacencyMatrix);

        // Display topological order
        System.out.println("Topological Order:");
        for (int vertex : topologicalOrder) {
            System.out.print("V" + vertex + " ");
        }
    }
}

