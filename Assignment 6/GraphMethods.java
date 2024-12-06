import java.util.*;

public class GraphMethods {
    // Find shortest distance using Dijkstra's algorithm
    public static int shortestDistance(Graph graph, String from, String to) {
        Map<String, Map<String, Integer>> adjList = graph.getAdjacencyList();
        if (!adjList.containsKey(from) || !adjList.containsKey(to)) return -1;

        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        distances.put(from, 0);
        pq.add(from);

        while (!pq.isEmpty()) {
            String current = pq.poll();
            int currentDistance = distances.get(current);

            if (current.equals(to)) return currentDistance;

            for (Map.Entry<String, Integer> neighbor : adjList.get(current).entrySet()) {
                int newDist = currentDistance + neighbor.getValue();
                if (newDist < distances.getOrDefault(neighbor.getKey(), Integer.MAX_VALUE)) {
                    distances.put(neighbor.getKey(), newDist);
                    pq.add(neighbor.getKey());
                }
            }
        }
        return -1;
    }

    // Find Minimum Spanning Tree using Prim's algorithm
    public static List<String[]> minimumSpanningTree(Graph graph) {
        Map<String, Map<String, Integer>> adjList = graph.getAdjacencyList();
        if (adjList.isEmpty()) return null;

        List<String[]> mst = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        PriorityQueue<String[]> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> Integer.parseInt(edge[2])));

        String start = adjList.keySet().iterator().next();
        visited.add(start);
        for (Map.Entry<String, Integer> neighbor : adjList.get(start).entrySet()) {
            pq.add(new String[]{start, neighbor.getKey(), String.valueOf(neighbor.getValue())});
        }

        while (!pq.isEmpty() && visited.size() < adjList.size()) {
            String[] edge = pq.poll();
            if (!visited.contains(edge[1])) {
                visited.add(edge[1]);
                mst.add(edge);
                for (Map.Entry<String, Integer> neighbor : adjList.get(edge[1]).entrySet()) {
                    if (!visited.contains(neighbor.getKey())) {
                        pq.add(new String[]{edge[1], neighbor.getKey(), String.valueOf(neighbor.getValue())});
                    }
                }
            }
        }

        return visited.size() == adjList.size() ? mst : null;
    }
}
