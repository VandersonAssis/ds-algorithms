package com.van.graph.helpers;

import com.van.graph.models.Vertex;

import java.util.*;

public class TopologicalSort<T> {
    public Deque<Vertex<T>> sort(Graph graph) {
        /**
         * This first loop is to get vertex that aren't children of any. So let's say we have the following graph:
         * (A -> C -> D) and (B -> C -> D) as you can see, C is the linking point among them both.
         * In this case the A and B vertexes are only accessible by this loop
         *
         * For more info, visit:
         * https://www.youtube.com/watch?v=ddTC4Zovtbc
         */

        Deque<Vertex<T>> stack = new ArrayDeque<>();
        Set<Vertex<T>> visited = new HashSet<>();
        for (Object currentV : graph.getAllVertex()) {
            Vertex<T> vertex = (Vertex) currentV;
            if(visited.contains(vertex))
                continue;

            this.sortUtil(vertex, stack, visited);
        }

        return stack;
    }

    private void sortUtil(Vertex<T> vertex, Deque<Vertex<T>> stack, Set<Vertex<T>> visited) {
        /**
         * Let's say we have a graph of D(F(G, H), I) and D is passed first in this method. So before adding D to the stack
         * the loop bellow recursively call this method passing F, which then call again passing G (which is child of F), after it calls
         * passing H and then since no more recursive calls are made, then the F is processed. After F and its children has been processed,
         * it calls passing I which is another child of D and only then D is added to the stack (processed).
         * So, by the end of this algorithm's execution, we'll have a topologically sorted stack
         */

        visited.add(vertex);
        for(Vertex<T> childVertex : vertex.getAdjacentVertexes()) {
            if(visited.contains(childVertex))
                continue;

            sortUtil(childVertex, stack, visited);
        }

        stack.offerFirst(vertex);
    }
}
