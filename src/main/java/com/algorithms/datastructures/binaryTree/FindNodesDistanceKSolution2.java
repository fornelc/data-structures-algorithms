package com.algorithms.datastructures.binaryTree;

import java.util.ArrayList;

public class FindNodesDistanceKSolution2 {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        ArrayList<Integer> nodesAtDistanceK = new ArrayList<>();
        findDistanceKFromNodeToTarget(tree, target, k, nodesAtDistanceK);
        return nodesAtDistanceK;
    }

    private int findDistanceKFromNodeToTarget(BinaryTree node, int target, int k,
                                               ArrayList<Integer> nodesAtDistanceK) {
        if (node == null) {
            return -1;
        }

        if (node.value == target) {
            findChildrenNodesWithDistanceKFromTarget(node, 0, k, nodesAtDistanceK);
            return 1;
        }

        int leftDistance = findDistanceKFromNodeToTarget(node.left, target, k, nodesAtDistanceK);
        int rightDistance = findDistanceKFromNodeToTarget(node.right, target, k, nodesAtDistanceK);

        if (leftDistance == k || rightDistance == k) {
            nodesAtDistanceK.add(node.value);
        }

        if (leftDistance != -1) {
            findChildrenNodesWithDistanceKFromTarget(node.right, leftDistance + 1, k, nodesAtDistanceK);
            return leftDistance + 1;
        }

        if (rightDistance != -1) {
            findChildrenNodesWithDistanceKFromTarget(node.left, rightDistance + 1, k, nodesAtDistanceK);
            return rightDistance + 1;
        }

        return -1;
    }

    private void findChildrenNodesWithDistanceKFromTarget(BinaryTree node, int distance, int k,
                                                          ArrayList<Integer> nodesAtDistanceK) {
        if (node == null) {
            return;
        }
        if (distance == k) {
            nodesAtDistanceK.add(node.value);
        }
        findChildrenNodesWithDistanceKFromTarget(node.left, distance + 1, k, nodesAtDistanceK);
        findChildrenNodesWithDistanceKFromTarget(node.right, distance + 1, k, nodesAtDistanceK);
    }
}
