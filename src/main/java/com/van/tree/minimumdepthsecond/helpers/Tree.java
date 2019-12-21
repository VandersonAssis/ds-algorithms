package com.van.tree.minimumdepthsecond.helpers;

import com.van.tree.minimumdepthsecond.models.Node;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    public Node root;

    public int findMinimumDepth() {
        int depth = 0;

        if(this.root == null) return depth;

        List<Node> queue = new ArrayList<>();
        queue.add(this.root);

        while(!queue.isEmpty()) {

            queue.add(queue.get(0).left);
            queue.add(queue.get(0).right);

            if(queue.get(0).left == null && queue.get(0).right == null)
                return depth;

            if(queue.get(0).left != null || queue.get(0).right != null)
                ++depth;

            queue.remove(0);
        }

        return depth;
    }

    public void insert(int value) {
        if(this.root == null) {
            this.root = new Node(value);
            return;
        }

        List<Node> queue = new ArrayList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            queue.add(queue.get(0).left);
            queue.add(queue.get(0).right);

            if(queue.get(0).left == null) {
                queue.get(0).left = new Node(value);
                return;
            } else if(queue.get(0).right == null) {
                queue.get(0).right = new Node(value);
                return;
            }

            queue.remove(0);
        }
    }

    public void print() {
        if(this.root == null) return;

        List<Node> queue = new ArrayList<>();
        queue.add(this.root);

        while(!queue.isEmpty()) {
            queue.add(queue.get(0).left);
            queue.add(queue.get(0).right);

            System.out.println(queue.get(0).value);

            queue.remove(queue.get(0));
        }
    }
}
