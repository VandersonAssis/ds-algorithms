package com.van.tree;

import com.van.tree.helpers.Node;
import com.van.tree.helpers.TreeHelper;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraverse {
    public static void main(String[] args) {
        traverse(TreeHelper.build());
    }

    private static void traverse(Node root) {
        List<Node> queue = new ArrayList<>();
        //The level order traversal is traverse level by level

        queue.add(root);
        while(queue.size() > 0) {
            queue.add(queue.get(0).left);
            queue.add(queue.get(0).right);

            if(queue.get(0) != null)
                System.out.println(queue.get(0).value);

            queue.remove(0);
        }
    }
}
