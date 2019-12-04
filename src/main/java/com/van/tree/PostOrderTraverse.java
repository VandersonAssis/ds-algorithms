package com.van.tree;

import com.van.tree.helpers.Node;
import com.van.tree.helpers.TreeHelper;

public class PostOrderTraverse {
    public static void main(String[] args) {
        traverse(TreeHelper.build());
    }

    public static void traverse(Node root) {
        //On the post traverse we travel left subtree, right subtree and then root

        if(root == null) return;

        traverse(root.left);
        traverse(root.right);
        System.out.println(root.value);
    }
}
