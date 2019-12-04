package com.van.tree;

import com.van.tree.helpers.Node;
import com.van.tree.helpers.TreeHelper;

public class PreOrderTraverse {
    public static void main(String[] args) {
        traverse(TreeHelper.build());
    }

    public static void traverse(Node root) {
        //Pre-Order traversal: Root, left subtree and then right subtree
        if(root == null){
            System.out.println("Traverse finished...");
            return;
        }

        System.out.println("Current is " + root.value);
        //By calling left, before right, we're stacking the right calls, so all the lefts will be executed first.
        //For more info, visit the link bellow. It's the pre-order traversal binary tree(LL) of the Data Structure & algorithms from ds guy
        //https://www.udemy.com/course/learn-data-structure-algorithms-with-java-interview/learn/lecture/12486356#questions
        traverse(root.left);
        traverse(root.right);
    }
}
