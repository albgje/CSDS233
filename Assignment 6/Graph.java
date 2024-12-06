import java.util.*;

public class Graph {
    private final Map<String, Map<String, Integer>> adjacencyList;

    // Constructor for Graph
    public Graph() {
        this.adjacencyList = new TreeMap<>();
    }

    // Add a node to the graph
    public boolean addNode(String name) {
        if (adjacencyList.containsKey(name)) {
            return false;
        }
        adjacencyList.put(name, new TreeMap<>());
        return true;
    }

    // Add an undirected edge with a weight
    public boolean addEdge(String from, String to, int weight) {
        if (weight < 0 || !adjacencyList.containsKey(from) || !adjacencyList.containsKey(to)) {
            return false;
        }
        Map<String, Integer> neighbors = adjacencyList.get(from);
        if (neighbors.containsKey(to)) {
            return false;
        }
        neighbors.put(to, weight);
        adjacencyList.get(to).put(from, weight);
        return true;
    }

    // Add multiple edges from one node
    public boolean addEdges(String from, String[] toList, int[] weightList) {
        if (toList.length != weightList.length || !adjacencyList.containsKey(from)) {
            return false;
        }
        for (int i = 0; i < toList.length; i++) {
            if (weightList[i] < 0 || !addEdge(from, toList[i], weightList[i])) {
                return false;
            }
        }
        return true;
    }

    // Remove a node and its edges
    public boolean removeNode(String name) {
        if (!adjacencyList.containsKey(name)) {
            return false;
        }
        adjacencyList.remove(name);
        for (Map<String, Integer> neighbors : adjacencyList.values()) {
            neighbors.remove(name);
        }
        return true;
    }

    // Remove an edge
    public boolean removeEdge(String from, String to) {
        if (!adjacencyList.containsKey(from) || !adjacencyList.get(from).containsKey(to)) {
            return false;
        }
        adjacencyList.get(from).remove(to);
        adjacencyList.get(to).remove(from);
        return true;
    }

    // Print the graph as adjacency list
    public void printGraph() {
        for (Map.Entry<String, Map<String, Integer>> entry : adjacencyList.entrySet()) {
            StringBuilder sb = new StringBuilder(entry.getKey());
            for (Map.Entry<String, Integer> neighbor : entry.getValue().entrySet()) {
                sb.append(" ").append(neighbor.getValue()).append(" ").append(neighbor.getKey());
            }
            System.out.println(sb);
        }
    }

    // Create a graph from input
    public static Graph createGraph(String[][] input) {
        Graph graph = new Graph();
        try {
            for (String[] row : input) {
                if (row.length != 3) return null;
                String from = row[0], to = row[1];
                int weight = Integer.parseInt(row[2]);
                if (!graph.adjacencyList.containsKey(from)) graph.addNode(from);
                if (!graph.adjacencyList.containsKey(to)) graph.addNode(to);
                graph.addEdge(from, to, weight);
            }
        } catch (Exception e) {
            return null;
        }
        return graph;
    }

    // Accessor for adjacency list
    public Map<String, Map<String, Integer>> getAdjacencyList() {
        return adjacencyList;
    }
}
