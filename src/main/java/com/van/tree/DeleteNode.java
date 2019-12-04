package com.van.tree;

import com.van.tree.helpers.Node;
import com.van.tree.helpers.TreeHelper;

import java.util.ArrayList;
import java.util.List;

public class DeleteNode {
    public static void main(String[] args) {
        TreeHelper.print();
        deleteValue(TreeHelper.build(), 20);
        TreeHelper.print();
    }

    private static void deleteValue(Node root, int value) {
        //When deleting a node that at least one child, its better to move any leaf node value into the node to be deleted.
        if(root == null) return;

        int step = 0;
        Node nodeToDelete = null;
        List<Node> queue = new ArrayList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            ++step;
            queue.add(queue.get(0).left);
            queue.add(queue.get(0).right);

            if(queue.get(0).value == value) {
                //does it have any child? then hold node
                //go to the closest leaf node and replace it

                if(TreeHelper.isLeaf(queue.get(0))) {
                    queue.get(0).value = null;
                    break;
                } else {
                    nodeToDelete = queue.get(0);
                }

                System.out.println("Found in step " + step);
            }

            if(nodeToDelete != null && TreeHelper.isLeaf(queue.get(0))) {
                nodeToDelete.value = queue.get(0).value;
                queue.get(0).value = null;
                break;
            }

            queue.remove(0);
        }
    }
}
