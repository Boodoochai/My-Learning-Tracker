import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemoveVertexTest {
    @Test
    public void OneVertexGraph() {
        SimpleGraph graph = new SimpleGraph(10);
        graph.AddVertex(4);

        graph.RemoveVertex(0);

        Assertions.assertNull(graph.vertex[0]);
    }

    @Test
    public void ThreeVertexGraph() {
        SimpleGraph graph = new SimpleGraph(10);
        graph.AddVertex(4);
        graph.AddVertex(6);
        graph.AddVertex(8);

        graph.RemoveVertex(1);

        Assertions.assertEquals(4, graph.vertex[0].Value);
        Assertions.assertNull(graph.vertex[1]);
        Assertions.assertEquals(8, graph.vertex[2].Value);
    }
}
