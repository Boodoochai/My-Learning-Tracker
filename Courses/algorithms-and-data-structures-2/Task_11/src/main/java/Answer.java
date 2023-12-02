import java.util.*;

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

    public ArrayList<Vertex> WeakVertices()
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int[] distance = new int[max_vertex];
        Arrays.fill(distance, -1);
        distance[0] = 0;
        ArrayList<Vertex> weak = new ArrayList<>();

        while (!queue.isEmpty()) {
            int x = queue.poll();
            boolean flag = false;
            for (int i = 0; i < max_vertex; i++) {
                for (int j = 0; j < max_vertex; j++) {
                    if (m_adjacency[x][i] != 0 && m_adjacency[x][j] != 0 && (m_adjacency[i][j] != 0 || m_adjacency[j][i] != 0)) {
                        flag = true;
                    }
                }
            }
            if (!flag) {
                weak.add(vertex[x]);
            }
            for (int i = 0; i < max_vertex; i++) {
                if (m_adjacency[x][i] != 0 && distance[i] == -1) {
                    queue.add(i);
                    distance[i] = distance[x] + 1;

                }
            }
        }

        return weak;
    }

    public ArrayList<Vertex> BreadthFirstSearch(int VFrom, int VTo)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(VFrom);
        int[] distance = new int[max_vertex];
        Arrays.fill(distance, -1);
        distance[VFrom] = 0;
        int[] parents = new int[max_vertex];
        Arrays.fill(parents, -1);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 0; i < max_vertex; i++) {
                if (m_adjacency[x][i] != 0 && distance[i] == -1) {
                    queue.add(i);
                    distance[i] = distance[x] + 1;
                    parents[i] = x;
                }
            }
        }

        if (distance[VTo] == -1) {
            return new ArrayList<>();
        }

        Stack<Vertex> path_reversed = new Stack<>();
        int cur = VTo;
        while (parents[cur] != -1) {
            path_reversed.add(vertex[cur]);
            cur = parents[cur];
        }
        path_reversed.add(vertex[VFrom]);

        ArrayList<Vertex> path = new ArrayList<>();

        while (!path_reversed.isEmpty()) {
            path.add(path_reversed.pop());
        }

        return path;
    }

    public ArrayList<Vertex> DepthFirstSearch(int VFrom, int VTo) {
        for (Vertex vertex : this.vertex) {
            if (vertex != null) {
                vertex.Hit = false;
            }
        }

        Stack<Vertex> path = new Stack<>();

        vertex[VFrom].Hit = true;
        Dfs(VFrom, VTo, path);

        ArrayList<Vertex> arrayPath = new ArrayList<>();
        Stack<Vertex> reversedPath = new Stack<>();

        while (!path.isEmpty()) {
            reversedPath.add(path.pop());
        }

        while (!reversedPath.isEmpty()) {
            arrayPath.add(reversedPath.pop());
        }

        return arrayPath;
    }

    private boolean Dfs(int currentVertex, int endVertex, Stack<Vertex> path) {
        path.add(vertex[currentVertex]);
        if (currentVertex == endVertex) {
            return true;
        }

        for (int i = 0; i < max_vertex; i++) {
            if (m_adjacency[currentVertex][i] != 0 && !vertex[i].Hit) {
                vertex[i].Hit = true;
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