package com.van.tree;

import com.van.tree.helpers.Node;
import com.van.tree.helpers.TreeHelper;

public class InOrderTraverse {
    private static String outcome = "";

    public static void main(String[] args) {
        traverse(TreeHelper.build());
        System.out.println(outcome);
    }

    public static void traverse(Node root) {
        //In-Order traversal: left subtree, root, right subtree
        if(root == null) {
            System.out.println("Traverse finished...");
            return;
        }

        traverse(root.left);
        outcome += root.value + ",";
        traverse(root.right);
    }
}
