package javaPrep.datastructure.graphs;

public class AdjancencyMatrix {
    public int vertices;
    private int[][] adjacency_matrix;

    public AdjancencyMatrix(int v)
    {
        vertices = v;
        adjacency_matrix = new int[vertices + 1][vertices + 1];
    }

    public void makeEdge(int to, int from, int edge)
    {
        try
        {
            adjacency_matrix[to][from] = edge;
        }
        catch (ArrayIndexOutOfBoundsException index)
        {
            System.out.println("The vertices does not exists");
        }
    }

    public int getEdge(int to, int from)
    {
        try
        {
            return adjacency_matrix[to][from];
        }
        catch (ArrayIndexOutOfBoundsException index)
        {
            System.out.println("The vertices does not exists");
        }
        return -1;
    }

    public static void main(String args[])
    {
        int vertices = 4;
        AdjancencyMatrix graph;

        graph = new AdjancencyMatrix(4);

        graph.makeEdge(0, 1, 1);
        graph.makeEdge(0, 4, 1);

        graph.makeEdge(1, 0, 1);
        graph.makeEdge(1, 2, 1);
        graph.makeEdge(1, 3, 1);
        graph.makeEdge(1, 4, 1);

        graph.makeEdge(2, 1, 1);
        graph.makeEdge(2, 3, 1);

        graph.makeEdge(3, 1, 1);
        graph.makeEdge(3, 2, 1);
        graph.makeEdge(3, 4, 1);

        graph.makeEdge(4, 0, 1);
        graph.makeEdge(4, 1, 1);
        graph.makeEdge(4, 3, 1);

        for (int i = 1; i <= vertices; i++)
        {
            for (int j = 1; j <= vertices; j++)
                System.out.print(graph.getEdge(i, j) + " ");
            System.out.println();
        }
    }
}