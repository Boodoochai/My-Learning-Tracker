import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class DepthFirstSearch {
    @Test
    public void noPath() {
        SimpleGraph graph = new SimpleGraph(10);
        graph.AddVertex(1);
        graph.AddVertex(2);

        ArrayList<Vertex> path = graph.DepthFirstSearch(0, 1);

        Assertions.assertEquals(path.size(), 0);
    }

    @Test
    public void OneEdgePath() {
        SimpleGraph graph = new SimpleGraph(10);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddEdge(0, 1);

        ArrayList<Vertex> path = graph.DepthFirstSearch(0, 1);

        Assertions.assertEquals(path.size(), 2);
        Assertions.assertEquals(path.get(0).Value, 1);
        Assertions.assertEquals(path.get(1).Value, 2);
    }

    @Test
    public void TwoEdgePath() {
        SimpleGraph graph = new SimpleGraph(10);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddEdge(0, 1);
        graph.AddEdge(1, 2);

        ArrayList<Vertex> path = graph.DepthFirstSearch(0, 2);

        Assertions.assertEquals(3, path.size());
        Assertions.assertEquals(1, path.get(0).Value);
        Assertions.assertEquals(2, path.get(1).Value);
        Assertions.assertEquals(3, path.get(2).Value);
    }

    @Test
    public void ThreeEdgePath() {
        SimpleGraph graph = new SimpleGraph(10);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddVertex(5);
        graph.AddEdge(0, 1);
        graph.AddEdge(0, 4);
        graph.AddEdge(1, 2);
        graph.AddEdge(2, 3);

        ArrayList<Vertex> path = graph.DepthFirstSearch(0, 3);

        Assertions.assertEquals(4, path.size());
        Assertions.assertEquals(1, path.get(0).Value);
        Assertions.assertEquals(2, path.get(1).Value);
        Assertions.assertEquals(3, path.get(2).Value);
        Assertions.assertEquals(4, path.get(3).Value);
    }
}
