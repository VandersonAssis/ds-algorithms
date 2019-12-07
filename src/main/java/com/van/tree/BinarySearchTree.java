package com.van.tree;

import com.van.tree.helpers.BinarySearchTreeHelper;
import com.van.tree.helpers.Node;
import com.van.tree.helpers.TreeHelper;

public class BinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTreeHelper searchTree = new BinarySearchTreeHelper();
        Node root = searchTree.insert(null, 100);
        searchTree.insert(root, 80);
        searchTree.insert(root, 200);
        searchTree.insert(root, 70);
        searchTree.insert(root, 90);
        searchTree.insert(root, 85);
        searchTree.insert(root, 150);
        searchTree.insert(root, 300);
        searchTree.insert(root, 50);
        searchTree.insert(root, 250);
        searchTree.insert(root, 400);
        searchTree.insert(root, 40);
        searchTree.insert(root, 60);

        TreeHelper.print(root);

        System.out.println("finished");
    }
}
