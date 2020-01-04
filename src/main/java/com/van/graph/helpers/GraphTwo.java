package com.van.graph.helpers;

import com.van.graph.models.VertexOld;

import java.util.*;

public class GraphTwo {
    private Map<VertexOld, List<VertexOld>> adjVertices;
    private Stack<VertexOld> stack;
    Set<String> visited = new LinkedHashSet<>();

    public GraphTwo() {
        this.stack = new Stack<>();
        this.adjVertices = new LinkedHashMap<>();
    }

    public Set<String> breadthFirstTraversal(GraphTwo graph, String root) {
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);

        while(!queue.isEmpty()) {
            String vertex = queue.poll();
            for(VertexOld v : graph.getAdjVertices(vertex)) {
                if(!visited.contains(v.label)) {
                    visited.add(v.label);

                    queue.add(v.label);
                }
            }
        }

        return visited;
    }

    public Set<String> depthFirstTraversal(GraphTwo graph, String root) {
        Set<String> visited = new LinkedHashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            String vertex = stack.pop();

            if(!visited.contains(vertex)) {
                visited.add(vertex);

                for(VertexOld v : graph.getAdjVertices(vertex)) {
                    stack.push(v.label);
                }
            }
        }

        return visited;
    }

    public void addVertex(String label) {
        this.adjVertices.putIfAbsent(new VertexOld(label), new ArrayList<>());
    }

    public void removeVertex(String label) {
        VertexOld vertexOld = new VertexOld(label);
        adjVertices.values().stream().forEach(e -> e.remove(vertexOld));
        adjVertices.remove(new VertexOld(label));
    }

    public void addEdge(String label1, String label2) {
        VertexOld v1 = new VertexOld(label1);
        VertexOld v2 = new VertexOld(label2);
        this.adjVertices.get(v1).add(v2);
        this.adjVertices.get(v2).add(v1);
    }

    public void removeEdge(String label1, String label2) {
        VertexOld v1 = new VertexOld(label1);
        VertexOld v2 = new VertexOld(label2);
        List<VertexOld> eV1 = this.adjVertices.get(v1);
        List<VertexOld> ev2 = this.adjVertices.get(v2);

        if(eV1 != null)
            eV1.remove(v2);

        if(ev2 != null)
            ev2.remove(v1);
    }

    public List<VertexOld> getAdjVertices(String label) {
        return this.adjVertices.get(new VertexOld(label));
    }
}
