package javaPrep.datastructure.graphs;

import java.util.ArrayList;
import java.util.List;

public class AdjancencyMatrixNode {
    List<Node> nodes;
    int[][] matrix;
    AdjancencyMatrixNode(int size) {
        nodes = new ArrayList<>();
        matrix = new int[size][size];
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void addEdge(int src, int dst) {
        matrix[src][dst] = 1;
    }

    public boolean checkEdge(int src, int dst) {
        return matrix[src][dst] == 1;
    }

    public static void main(String[] args) {
        AdjancencyMatrixNode graph = new AdjancencyMatrixNode(5);

        graph.addNode(new Node('A'));
        graph.addNode(new Node('B'));
        graph.addNode(new Node('C'));
        graph.addNode(new Node('D'));
        graph.addNode(new Node('E'));

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 0);
        graph.addEdge(4, 2);
    }
}

class Node<T> {
    T value;

    Node(T value){
        this.value = value;
    }
}