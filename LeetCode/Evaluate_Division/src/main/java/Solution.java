import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    Graph<String, Double> graph = makeGraph(equations, values);
    Map<String, Map<String, Double>> results = new HashMap<>();
    double[] res = new double[queries.size()];

    for (int i = 0; i < queries.size(); i++) {
      List<String> querie = queries.get(i);
      if (!results.containsKey(querie.get(0)))
        calcForNode(graph, results, querie.get(0));
      if (!graph.data.containsKey(querie.get(0)) || !results.get(querie.get(0)).containsKey(querie.get(1))) {
        res[i] = -1;
        continue;
      }
      res[i] = results.get(querie.get(0)).get(querie.get(1));
    }

    return res;
  }

  static private void calcForNode(Graph<String, Double> graph, Map<String, Map<String, Double>> results, String node) {
    if (!graph.data.containsKey(node)) {
      return;
    }
    Queue<String> queue = new LinkedList<>();
    queue.add(node);
    Set<String> visited = new HashSet<>();
    visited.add(node);
    results.put(node, new HashMap<String, Double>());
    results.get(node).put(node, 1.0);

    while (!queue.isEmpty()) {
      String cur_node = queue.remove();
      if (!graph.data.containsKey(cur_node)) {
        continue;
      }
      for (String x : graph.data.get(cur_node).keySet()) {
        if (!visited.contains(x)) {
          visited.add(x);
          queue.add(x);
          results.get(node).put(x, results.get(node).get(cur_node) * graph.data.get(cur_node).get(x));
        }
      }
    }
  }

  static private Graph<String, Double> makeGraph(List<List<String>> equations, double[] values) {
    Graph<String, Double> graph = new Graph<>();
    for (int i = 0; i < equations.size(); i++) {
      List<String> equation = equations.get(i);
      graph.addEdge(equation.get(0), equation.get(1), values[i]);
      graph.addEdge(equation.get(1), equation.get(0), 1 / values[i]);
    }
    return graph;
  }

  static private class Graph<K, W> {
    Map<K, Map<K, W>> data;

    public Graph() {
      data = new HashMap<>();
    }

    public void addEdge(K node1, K node2, W weight) {
      if (!data.containsKey(node1))
        data.put(node1, new HashMap<>());
      data.get(node1).put(node2, weight);
    }
  }
}
