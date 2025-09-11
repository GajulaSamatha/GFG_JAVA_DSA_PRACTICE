import java.util.*;

class TSPGreedy {

    // Helper class to store a city and its distance
    static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        // Our weighted graph with cities and distances
        Map<String, List<Pair<String, Integer>>> graph = Map.of(
            "A", List.of(new Pair<>("B", 10), new Pair<>("C", 15), new Pair<>("D", 20)),
            "B", List.of(new Pair<>("A", 10), new Pair<>("C", 35), new Pair<>("D", 25)),
            "C", List.of(new Pair<>("A", 15), new Pair<>("B", 35), new Pair<>("D", 30)),
            "D", List.of(new Pair<>("A", 20), new Pair<>("B", 25), new Pair<>("C", 30))
        );

        // This is our main function to find the greedy path
        findGreedyPath(graph, "A");
    }

    public static void findGreedyPath(Map<String, List<Pair<String, Integer>>> graph, String startCity) {
        Set<String> visited = new HashSet<>();
        List<String> path = new ArrayList<>();
        int totalDistance = 0;
        String currentCity = startCity;

        // Start at our first city
        visited.add(currentCity);
        path.add(currentCity);

        // Keep going until all cities are visited
        while (visited.size() < graph.size()) {
            String nextCity = null;
            int minDistance = Integer.MAX_VALUE;

            // Find the nearest unvisited city
            for (Pair<String, Integer> neighbor : graph.get(currentCity)) {
                if (!visited.contains(neighbor.getKey())) {
                    if (neighbor.getValue() < minDistance) {
                        minDistance = neighbor.getValue();
                        nextCity = neighbor.getKey();
                    }
                }
            }

            // Move to the next city and add the distance
            if (nextCity != null) {
                totalDistance += minDistance;
                currentCity = nextCity;
                visited.add(currentCity);
                path.add(currentCity);
            }
        }

        // Add the final leg back to the starting city
        String lastCity = path.get(path.size() - 1);
        for (Pair<String, Integer> neighbor : graph.get(lastCity)) {
            if (neighbor.getKey().equals(startCity)) {
                totalDistance += neighbor.getValue();
                path.add(startCity);
                break;
            }
        }

        // Print the result
        System.out.println("The path is: " + path);
        System.out.println("The total distance is: " + totalDistance);
    }
}
