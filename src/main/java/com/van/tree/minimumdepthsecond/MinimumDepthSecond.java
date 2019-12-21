package com.van.tree.minimumdepthsecond;

import com.van.tree.minimumdepthsecond.helpers.Tree;

public class MinimumDepthSecond {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);

        System.out.println(tree.findMinimumDepth());
    }
}
