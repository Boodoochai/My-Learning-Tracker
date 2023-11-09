import java.util.ArrayList;
import java.util.Stack;

class Vertex {
    public int Value;
    public boolean Hit;

    public Vertex(int val) {
        Value = val;
        Hit = false;
    }
}

class SimpleGraph {
    Vertex[] vertex;
    int[][] m_adjacency;
    int max_vertex;

    public SimpleGraph(int size) {
        max_vertex = size;
        m_adjacency = new int[size][size];
        vertex = new Vertex[size];
    }

    public ArrayList<Vertex> DepthFirstSearch(int VFrom, int VTo) {
        for (Vertex vertex : this.vertex) {
            if (vertex != null) {
                vertex.Hit = false;
            }
        }

        Stack<Vertex> path = new Stack<>();

        Dfs(VTo, VFrom, path);

        ArrayList<Vertex> arrayPath = new ArrayList<>();

        while (!path.isEmpty()) {
            arrayPath.add(path.pop());
        }

        return arrayPath;
    }

    private boolean Dfs(int currentVertex, int endVertex, Stack<Vertex> path) {
        path.add(vertex[currentVertex]);
        if (currentVertex == endVertex) {
            return true;
        }

        vertex[currentVertex].Hit = true;

        for (int i = 0; i < max_vertex; i++) {
            if (m_adjacency[currentVertex][i] != 0) {
                if (Dfs(i, endVertex, path)) {
                    return true;
                }
            }
        }

        path.pop();
        return false;
    }


    public void AddVertex(int value) {
        Vertex newVertex = new Vertex(value);
        for (int i = 0; i < max_vertex; i++) {
            if (vertex[i] == null) {
                vertex[i] = newVertex;
                break;
            }
        }
    }

    public void RemoveVertex(int v) {
        for (int i = 0; i < max_vertex; i++) {
            m_adjacency[i][v] = 0;
            m_adjacency[v][i] = 0;
        }
        vertex[v] = null;
    }

    public boolean IsEdge(int v1, int v2) {
        return m_adjacency[v1][v2] == 1;
    }

    public void AddEdge(int v1, int v2) {
        m_adjacency[v1][v2] = 1;
        m_adjacency[v2][v1] = 1;
    }

    public void RemoveEdge(int v1, int v2) {
        m_adjacency[v1][v2] = 0;
        m_adjacency[v2][v1] = 0;
    }
}