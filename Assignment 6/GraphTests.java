import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class GraphTests {

    @Test
    public void testAddNode() {
        Graph graph = new Graph();

        assertTrue(graph.addNode("A"), "Adding a new node should return true.");
        assertTrue(graph.addNode("B"), "Adding another new node should return true.");
        assertFalse(graph.addNode("A"), "Adding an existing node should return false.");
    }

    @Test
    public void testAddEdge() {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");

        assertTrue(graph.addEdge("A", "B", 5), "Adding a valid edge should return true.");
        assertTrue(graph.addEdge("B", "C", 10), "Adding another valid edge should return true.");
        assertFalse(graph.addEdge("A", "B", 3), "Adding an existing edge should return false.");
        assertFalse(graph.addEdge("A", "D", 7), "Adding an edge to a non-existent node should return false.");
        assertFalse(graph.addEdge("A", "C", -1), "Adding an edge with a negative weight should return false.");
    }

    @Test
    public void testRemoveNode() {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addEdge("A", "B", 5);

        assertTrue(graph.removeNode("A"), "Removing an existing node should return true.");
        assertFalse(graph.removeNode("A"), "Removing a non-existent node should return false.");
        assertFalse(graph.getAdjacencyList().get("B").containsKey("A"), "Edges connected to the removed node should be deleted.");
    }

    @Test
    public void testRemoveEdge() {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addEdge("A", "B", 5);

        assertTrue(graph.removeEdge("A", "B"), "Removing an existing edge should return true.");
        assertFalse(graph.removeEdge("A", "B"), "Removing a non-existent edge should return false.");
        assertFalse(graph.removeEdge("A", "C"), "Removing an edge to a non-existent node should return false.");
    }

    @Test
    public void testCreateGraph() {
        String[][] input = {
            {"A", "B", "5"},
            {"B", "C", "10"},
            {"C", "A", "15"}
        };
        Graph graph = Graph.createGraph(input);

        assertNotNull(graph, "Valid input should create a graph.");
        assertEquals(3, graph.getAdjacencyList().size(), "Graph should have 3 nodes.");
        assertTrue(graph.getAdjacencyList().get("A").containsKey("B"), "Graph should have the edge A-B.");
        assertTrue(graph.getAdjacencyList().get("C").containsKey("A"), "Graph should have the edge C-A.");
    }

    @Test
    public void testCreateGraphInvalidInput() {
        String[][] invalidInput = {
            {"A", "B", "5"},
            {"B", "C"} // Invalid row
        };
        Graph graph = Graph.createGraph(invalidInput);

        assertNull(graph, "Invalid input should return null.");
    }

    @Test
    public void testPrintGraph() {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 10);

        // Output can't be directly captured but testing if nodes and edges exist
        assertTrue(graph.getAdjacencyList().containsKey("A"));
        assertTrue(graph.getAdjacencyList().get("A").containsKey("B"));
        assertTrue(graph.getAdjacencyList().get("A").containsKey("C"));
    }

    @Test
    public void testShortestDistance() {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B", 5);
        graph.addEdge("B", "C", 10);

        assertEquals(15, GraphMethods.shortestDistance(graph, "A", "C"), "Shortest distance A-C should be 15.");
        assertEquals(5, GraphMethods.shortestDistance(graph, "A", "B"), "Shortest distance A-B should be 5.");
        assertEquals(-1, GraphMethods.shortestDistance(graph, "A", "D"), "Non-existent node should return -1.");
    }

    @Test
    public void testMinimumSpanningTree() {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B", 5);
        graph.addEdge("B", "C", 10);
        graph.addEdge("C", "A", 15);

        List<String[]> mst = GraphMethods.minimumSpanningTree(graph);
        assertNotNull(mst, "MST should not be null for a connected graph.");
        assertEquals(2, mst.size(), "MST should have 2 edges for 3 nodes.");

        // Verify edges in MST
        boolean edge1Found = false, edge2Found = false;
        for (String[] edge : mst) {
            if ((edge[0].equals("A") && edge[1].equals("B") && edge[2].equals("5")) ||
                (edge[1].equals("A") && edge[0].equals("B") && edge[2].equals("5"))) {
                edge1Found = true;
            }
            if ((edge[0].equals("B") && edge[1].equals("C") && edge[2].equals("10")) ||
                (edge[1].equals("B") && edge[0].equals("C") && edge[2].equals("10"))) {
                edge2Found = true;
            }
        }
        assertTrue(edge1Found, "Edge A-B with weight 5 should be in the MST.");
        assertTrue(edge2Found, "Edge B-C with weight 10 should be in the MST.");
    }
}
