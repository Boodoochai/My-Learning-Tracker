import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddVertexTest {
    @Test
    public void EmptyGraph() {
        SimpleGraph graph = new SimpleGraph(10);
        graph.AddVertex(4);

        Assertions.assertEquals(4, graph.vertex[0].Value);
    }

    @Test
    public void NotEmptyGraph() {
        SimpleGraph graph = new SimpleGraph(10);
        graph.AddVertex(4);
        graph.AddVertex(6);
        graph.AddVertex(8);

        Assertions.assertEquals(4, graph.vertex[0].Value);
        Assertions.assertEquals(6, graph.vertex[1].Value);
        Assertions.assertEquals(8, graph.vertex[2].Value);
    }

    @Test
    public void AfterRemoveGraph() {
        SimpleGraph graph = new SimpleGraph(10);
        graph.AddVertex(4);
        graph.AddVertex(6);
        graph.AddVertex(8);

        graph.RemoveVertex(1);
        graph.AddVertex(10);

        Assertions.assertEquals(4, graph.vertex[0].Value);
        Assertions.assertEquals(10, graph.vertex[1].Value);
        Assertions.assertEquals(8, graph.vertex[2].Value);
    }
}