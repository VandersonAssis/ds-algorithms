package com.van.graph.dijkstra;

import com.van.graph.dijkstra.helpers.Graph;
import com.van.graph.dijkstra.models.Vertex;

import java.util.Arrays;

public class DijkstraMain {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('A', Arrays.asList(new Vertex('B', 7), new Vertex('C', 8)));
        graph.addVertex('B', Arrays.asList(new Vertex('A', 7), new Vertex('F', 2)));
        graph.addVertex('C', Arrays.asList(new Vertex('A', 8), new Vertex('F', 6), new Vertex('G', 4)));
        graph.addVertex('D', Arrays.asList(new Vertex('F', 8)));
        graph.addVertex('E', Arrays.asList(new Vertex('H', 1)));
        graph.addVertex('F', Arrays.asList(new Vertex('B', 2), new Vertex('C', 6), new Vertex('D', 8), new Vertex('G', 9), new Vertex('H', 3)));
        graph.addVertex('G', Arrays.asList(new Vertex('C', 4), new Vertex('F', 9)));
        graph.addVertex('H', Arrays.asList(new Vertex('E', 1), new Vertex('F', 3)));

        System.out.println(graph.getShortestPath('A', 'H'));
    }
}
