package com.van.tree.helpers;

public class BinarySearchTreeHelper {
    public Node insert(Node current, Integer value) {
        if(current == null) {
            current = new Node(value);
            return current;
        }

        else if(value <= current.value)
            current.left = insert(current.left, value);
        else
            current.right = insert(current.right, value);

        return current;
    }
}
