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

        //This priority queue uses the compareTo method from the Vertex to decide if the added Vertex is going to be in the beginning of the
        //list or not. This will basically sort the list according to the verticies' distance
        PriorityQueue<Vertex> vertexPriorityQ = new PriorityQueue<>();

        //Setting the start distances of all the vertexPriorityQ. Basically, if the node is not the start node, then it's set to infinite
        for(Character character : this.vertices.keySet()) {
            if(character == start) {
                distances.put(character, 0);
                vertexPriorityQ.add(new Vertex(character, 0));
            } else {
                distances.put(character, Integer.MAX_VALUE);
                vertexPriorityQ.add(new Vertex(character, Integer.MAX_VALUE));
            }

            previous.put(character, null);
        }

        while(!vertexPriorityQ.isEmpty()) {
            //Since on the algorithm above we've put the start character with a distance of zero, then it will be the first one to be pulled
            //from the priority queue bellow
            Vertex newSmallest = vertexPriorityQ.poll();

            //If the newSmallest is the destination node, then, add it to the resulting path, and then load all the parents from the previous map
            if(newSmallest.getId() == finish) {
                final List<Character> path = new ArrayList<>();

                while(previous.get(newSmallest.getId()) != null) {
                    path.add(newSmallest.getId());
                    newSmallest = previous.get(newSmallest.getId());
                }

                return path;
            }

            if(distances.get(newSmallest.getId()) == Integer.MAX_VALUE)
                break;

            List<Vertex> neighbors = this.vertices.get(newSmallest.getId());
            for(Vertex neighbor : neighbors) {

                //This distances map holds the sum of the distances to the start node
                Integer summedDistance = distances.get(newSmallest.getId()) + neighbor.getDistance();
                if(summedDistance < distances.get(neighbor.getId())) {
                    distances.put(neighbor.getId(), summedDistance);
                    previous.put(neighbor.getId(), newSmallest);

                    for(Vertex n : vertexPriorityQ) {
                        if(n.getId() == neighbor.getId()) {
                            vertexPriorityQ.remove(n);
                            n.setDistance(summedDistance);
                            vertexPriorityQ.add(n);
                            break;
                        }
                    }
                }
            }
        }

        return new ArrayList<>(distances.keySet());
    }
}
