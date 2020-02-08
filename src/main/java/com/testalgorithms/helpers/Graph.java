package com.testalgorithms.helpers;

import java.util.*;

public class Graph {
    private Map<Character, List<Vertex>> vertices;

    public Graph() {
        this.vertices = new HashMap<>();
    }

    public void addVertex(Character id, List<Vertex> vertices) {
        this.vertices.put(id, vertices);
    }

    public List<Character> getShortestPath(Character start, Character finish) {
        Map<Character, Integer> distances = new HashMap<>();
        Map<Character, Character> previous = new HashMap<>();
        PriorityQueue<Vertex> verticesQ = new PriorityQueue<>();
        List<Character> path = new ArrayList<>();

        for(Map.Entry<Character, List<Vertex>> currentVertex : this.vertices.entrySet()) {
            if(currentVertex.getKey().equals(start)) {
                distances.put(currentVertex.getKey(), 0);
                verticesQ.add(new Vertex(currentVertex.getKey(), 0));
            }
            else {
                distances.put(currentVertex.getKey(), Integer.MAX_VALUE);
                verticesQ.add(new Vertex(currentVertex.getKey(), Integer.MAX_VALUE));
            }

            previous.put(currentVertex.getKey(), null);
        }

        while(!verticesQ.isEmpty()) {
            Vertex smallest = verticesQ.poll();

            if(smallest.getId() == finish) {
                Character current = smallest.getId();

                while(previous.get(current) != null) {
                    path.add(previous.get(current));
                    current = previous.get(current);
                }

                return path;
            }

            List<Vertex> neighbors = this.vertices.get(smallest.getId());

            for(Vertex neighbor : neighbors) {
                Integer summedDistance = distances.get(smallest.getId()) + neighbor.getDistance();
                if(summedDistance < distances.get(smallest.getId())) {
                    distances.remove(neighbor.getId());
                    neighbor.setDistance(summedDistance);
                    distances.put(neighbor.getId(), summedDistance);
                    previous.put(neighbor.getId(), smallest.getId());
                }
            }
        }

        return path;
    }
}
