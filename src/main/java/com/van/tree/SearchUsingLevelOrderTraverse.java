package com.van.tree;

import com.van.tree.helpers.Node;
import com.van.tree.helpers.TreeHelper;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class SearchUsingLevelOrderTraverse {
    public static void main(String[] args) {
        search(TreeHelper.build(), 500);
    }

    private static void search(Node root, int value) {
        if(root == null) {
            System.out.println("The tree has not been initialized");
            return;
        }

        int steps = 0;
        List<Node> queue = new ArrayList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            ++steps;

            queue.add(queue.get(0).left);
            queue.add(queue.get(0).right);

            if(queue.get(0).value == value) {
                System.out.println(format("Value %d found in %d steps", value, steps));
                break;
            }

            queue.remove(0);
        }

        System.out.println("Finished...");
    }
}
