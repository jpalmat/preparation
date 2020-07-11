package collection;

import java.util.ArrayList;

public class TwoDimmentional {
    public static void main(String[] args) {
        int vertexCount = 3;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(vertexCount);
        for(int i = 0; i<vertexCount; i++){
            graph.add(new ArrayList<Integer>());
        }

        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(0);

        graph.get(1).add(0);
        graph.get(2).add(1);
        graph.get(0).add(2);

        for (int i = 0; i < vertexCount; i++) {
            int edgeCount = graph.get(i).size();
            for (int j = 0; j < edgeCount; j++) {
                Integer startVertex = i;
                Integer endVertex = graph.get(i).get(j);
                System.out.printf("Vertex %d is connected to vertex %d%n", startVertex, endVertex);
            }
        }

    }
}
