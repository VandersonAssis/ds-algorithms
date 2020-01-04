package com.van.graph;

import com.van.graph.helpers.GraphTwo;
import com.van.graph.helpers.Graph;
import com.van.graph.helpers.TopologicalSort;
import com.van.graph.models.Vertex;

import java.util.Deque;

public class GraphMain {
    public static void main(String[] args) {
//        AdjacencyListGraph graph1 = create();
//        Set<String> visited = graph1.breadthFirstTraversal(graph1, "Alice");
//        Set<String> visited1 = graph1.depthFirstTraversal(graph1, "Alice");

//        System.out.println(visited);

        Graph<Integer> graph = createWithInteger();
        TopologicalSort<Integer> topologicalSort = new TopologicalSort<>();
        Deque<Vertex<Integer>> result = topologicalSort.sort(graph);

        while(!result.isEmpty()) {
            System.out.println(result.poll());
        }
    }

    private static Graph<Integer> createWithInteger() {
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 8);
        graph.addEdge(8, 11);

        return graph;
    }

    private static GraphTwo create() {
        GraphTwo graph = new GraphTwo();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");

        return graph;
    }
}
