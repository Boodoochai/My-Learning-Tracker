import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public boolean isBipartite(int[][] graph) {
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            if (!visited.contains(i) && !isConectedBipartite(graph, i, visited))
                return false;
        }
        return true;
    }

    private boolean isConectedBipartite(int[][] graph, int start_node, Set<Integer> visited) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] colors = new boolean[101];
        colors[start_node] = true;
        queue.add(start_node);
        visited.add(start_node);
        while (!queue.isEmpty()) {
            Integer node = queue.remove();
            for (int x : graph[node]) {
                if (!visited.contains(x)) {
                    queue.add(x);
                    colors[x] = !colors[node];
                    visited.add(x);
                }
                if (colors[node] == colors[x]) {
                    return false;
                }
            }
        }
        return true;
    }
}
