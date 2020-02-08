package com.testalgorithms;
import com.testalgorithms.helpers.Graph;
import com.testalgorithms.helpers.Vertex;

import java.util.Arrays;

public class DijkstraCustomMain {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex('A', Arrays.asList(new Vertex('B', 7), new Vertex('C', 8)));
        graph.addVertex('B', Arrays.asList(new Vertex('A', 7), new Vertex('F', 2)));
        graph.addVertex('C', Arrays.asList(new Vertex('A', 8), new Vertex('F', 6), new Vertex('G', 4)));
        graph.addVertex('F', Arrays.asList(new Vertex('B', 2), new Vertex('C', 6), new Vertex('G', 9), new Vertex('H', 1), new Vertex('D', 8)));
        graph.addVertex('G', Arrays.asList(new Vertex('C', 4), new Vertex('F', 9)));
        graph.addVertex('D', Arrays.asList(new Vertex('F', 8)));
        graph.addVertex('H', Arrays.asList(new Vertex('F', 1), new Vertex('E', 1)));

        System.out.println(graph.getShortestPath('A', 'H'));
    }
}
