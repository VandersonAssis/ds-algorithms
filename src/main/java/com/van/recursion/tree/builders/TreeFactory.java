package com.van.recursion.tree.builders;

import com.van.recursion.tree.Node;

import java.util.List;

public class TreeFactory {
    private Node root;

    public Node create(List<Integer> numbers) {
        if(numbers == null || numbers.isEmpty()) return null;

        for(int i = 0; i < numbers.size(); i++) {
            this.root = this.add(numbers.get(i));
        }

        return root;
    }

    private Node add(int number) {
        if(number > this.root.number) {
            this.root.right = new Node(number);
        } else {
            this.root.left = new Node(number);
        }


//        Node newNode = new Node(number);
//
//        if(number >= current.number)
//            current.right = newNode;
//        else
//            current.left = newNode;
//
//        return newNode;
    }
}
