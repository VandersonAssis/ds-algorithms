package com.van.tree.helpers;

import java.util.ArrayList;
import java.util.List;

public class TreeHelper {
    private static Node root;

    public static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    public static void print() {
        List<Node> queue = new ArrayList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            if(queue.get(0) != null) {
                queue.add(queue.get(0).left);
                queue.add(queue.get(0).right);

                System.out.println(queue.get(0).value);
            }

            queue.remove(0);
        }
    }

    public static Node build() {
        insert(20);
        insert(100);
        insert(3);
        insert(50);
        insert(15);
        insert(250);
        insert(35);
        insert(222);

        return root;
    }

    public static void insert(Integer value) {
        if(root == null) {
            root = new Node(value);
            return;
        }

        List<Node> queue = new ArrayList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            queue.add(queue.get(0).left);
            queue.add(queue.get(0).right);

            if(queue.get(0).left == null) {
                queue.get(0).left = new Node(value);
                break;
            }
            else if(queue.get(0).right == null) {
                queue.get(0).right = new Node(value);
                break;
            }

            queue.remove(0);
        }
    }

    private static Node freakedUpBuild() {
        root = new Node(20);
        root.left = new Node(100);
        root.left.left = new Node(50);
        root.left.left.left = new Node(222);

        root.left.right = new Node(15);

        root.right = new Node(3);
        root.right.left = new Node(250);
        root.right.right = new Node(35);

        return root;
    }
}
