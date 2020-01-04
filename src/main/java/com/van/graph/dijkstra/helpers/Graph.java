package com.van.graph.dijkstra.helpers;

import com.van.graph.dijkstra.models.Vertex;

import java.util.*;

public class Graph {
    private final Map<Character, List<Vertex>> vertices;

    public Graph() {
        this.vertices = new HashMap<>();
    }

    public void addVertex(Character character, List<Vertex> vertex) {
        this.vertices.put(character, vertex);
    }

    public List<Character> getShortestPath(Character start, Character finish) {
        final Map<Character, Integer> distances = new HashMap<>();
        final Map<Character, Vertex> previous = new HashMap<>();
        PriorityQueue<Vertex> nodes = new PriorityQueue<>();

        //Setting the infinite nodes and the start?
        for(Character vertex : this.vertices.keySet()) {
            if(vertex == start) {
                distances.put(vertex, 0);
                nodes.add(new Vertex(vertex, 0));
            } else {
                distances.put(vertex, Integer.MAX_VALUE);
                nodes.add(new Vertex(vertex, Integer.MAX_VALUE));
            }

            previous.put(vertex, null);
        }

        while(!nodes.isEmpty()) {
            Vertex smallest = nodes.poll();
            if(smallest.getCharacter() == finish) {
                final List<Character> path = new ArrayList<>();

                while(previous.get(smallest.getCharacter()) != null) {
                    path.add(smallest.getCharacter());
                    smallest = previous.get(smallest.getCharacter());
                }

                return path;
            }

            if(distances.get(smallest.getCharacter()) == Integer.MAX_VALUE)
                break;

            for(Vertex neighbor : vertices.get(smallest.getCharacter())) {
                Integer alt = distances.get(smallest.getCharacter()) + neighbor.getDistance();
                if(alt < distances.get(neighbor.getCharacter())) {
                    distances.put(neighbor.getCharacter(), alt);
                    previous.put(neighbor.getCharacter(), smallest);

                    forLoop:
                    for(Vertex n : nodes) {
                        if(n.getCharacter() == neighbor.getCharacter()) {
                            nodes.remove(n);
                            n.setDistance(alt);
                            nodes.add(n);
                            break forLoop;
                        }
                    }
                }
            }
        }

        return new ArrayList<>(distances.keySet());
    }
}
