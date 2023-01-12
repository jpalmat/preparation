package javaPrep.datastructure.graphs;

import java.util.*;

public class AdjacencyList<T> {
    private Map<T, List<T>> graph = new HashMap<>();

    public void addEdge(T source, T destination, boolean biDirectional) {
        if (!graph.containsKey(source)) {
            addVertex(source);
        }

        if (!graph.containsKey(destination)) {
            addVertex(destination);
        }

        graph.get(source).add(destination);
        if(biDirectional == true) {
            graph.get(destination).add(source);
        }
    }

    public void hasVertex(T vertex) {
        if(graph.containsKey(vertex)) {
            System.out.println("The Graph contains " + vertex + " as a vertex");
        }else {
            System.out.println("The Graph does not contain " + vertex + " as a vertex");
        }
    }

    public void hasEdge(T source, T destination) {
        if(graph.get(source).contains(destination)) {
            System.out.println("The Graph has an edge between " + source + " and " + destination);
        }else {
            System.out.println("The Graph has no edge between " + source + " and " + destination);
        }
    }

    public String printGraph() {
        StringBuilder builder = new StringBuilder();

        for(T vertex : graph.keySet()) {
            builder.append(vertex.toString() + ": ");
            for(T node: graph.get(vertex)) {
                builder.append(node.toString() + " ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    private void addVertex(T vertex) {
        graph.put(vertex, new LinkedList<T>());
    }

    //TRAVERSE ALGORITHM
    //depth first search
    //iterative
    void DFS(T n)
    {
        Set<T> nodesVisited = new TreeSet<>();

        Stack<T> stack = new Stack<>();

        stack.push(n);                                    //push root node to the stack
        T a;

        while(!stack.empty())
        {
            n = stack.peek();                       //extract the top element of the stack
            stack.pop();                            //remove the top element from the stack

            if(!nodesVisited.contains(n))
            {
                System.out.print(n + " ");
                nodesVisited.add(n);
            }

            for (int i = 0; i < graph.get(n).size(); i++)  //iterate through the linked list and then propagate to the next few nodes
            {
                a = graph.get(n).get(i);
                if (!nodesVisited.contains(a))                    //only push those nodes to the stack which aren't in it already
                {
                    stack.push(a);                          //push the top element to the stack
                }
            }

        }
    }

    public static void main(String[] args) {
        AdjacencyList<String> graphObject = new AdjacencyList<>();

        graphObject.addEdge("a", "b", false);
        graphObject.addEdge("a", "c", false);
        graphObject.addEdge("b", "d", false);
        graphObject.addEdge("c", "e", false);
        graphObject.addEdge("d", "f", false);
//        graphObject.addEdge(4, 0, false);
//        graphObject.addEdge(4, 1, false);
//        graphObject.addEdge(4, 3, false);


//        System.out.println("Graph:\n"
//                + graphObject.printGraph());

        graphObject.hasVertex("a");
        graphObject.hasEdge("a","b");

        graphObject.DFS("a");
    }
}