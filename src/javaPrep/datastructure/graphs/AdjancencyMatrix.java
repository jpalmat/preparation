package javaPrep.datastructure.graphs;

import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class AdjancencyMatrix {
    public int vertices;
    private int[][] adjacency_matrix;

    class pair
    {
        public int first;
        public int second;

        public pair(int first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }

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
            adjacency_matrix[from][to] = edge;
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

    Boolean isValid(boolean vis[][], int row,
                    int col)
    {

        // If cell is out of bounds
        if (row < 0 || col < 0 ||
                row >= vertices || col >= vertices)
            return false;

        // If the cell is already visited
        if (vis[row][col])
            return false;

        // Otherwise, it can be visited
        return true;
    }

    // prints all not yet visited vertices reachable from s
    void DFS(int row, int col, boolean vis[][])
    {

        // Initialize a stack of pairs and
        // push the starting cell into it
        Stack<pair> st = new Stack<pair>();
        st.push(new pair(row, col));

        // Iterate until the
        // stack is not empty
        while (!st.empty())
        {

            // Pop the top pair
            pair curr = st.pop();

            row = curr.first;
            col = curr.second;

            // Check if the current popped
            // cell is a valid cell or not
            if (!isValid(vis, row, col))
                continue;

            // Mark the current
            // cell as visited
            vis[row][col] = true;

            // Print the element at
            // the current top cell
            System.out.print(adjacency_matrix[row][col] + " ");

            // Push all the adjacent cells
            for(int i = 0; i < 4; i++)
            {
                int adjx = row;
                int adjy = col;
                st.push(new pair(adjx, adjy));
            }
        }
    }

    public static void main(String args[])
    {
        AdjancencyMatrix graph = new AdjancencyMatrix(6);

        graph.makeEdge(0, 1, 1);
        graph.makeEdge(0, 2, 1);

        graph.makeEdge(1, 3, 1);
        graph.makeEdge(2, 4, 1);

        graph.makeEdge(3, 5, 1);

//        for (int i = 1; i <= vertices; i++)
//        {
//            for (int j = 1; j <= vertices; j++)
//                System.out.print(graph.getEdge(i, j) + " ");
//            System.out.println();

        boolean vis[][] = new boolean[6][6];
//        }
        graph.DFS(0, 0, vis);
    }
}