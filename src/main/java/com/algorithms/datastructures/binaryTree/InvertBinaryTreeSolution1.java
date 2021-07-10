package com.algorithms.datastructures.binaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

public class InvertBinaryTreeSolution1 {
    public static void invertBinaryTree(BinaryTree tree) {
        Deque<BinaryTree> queue = new ArrayDeque<>();
        queue.addLast(tree);
        while (queue.size() > 0) {
            BinaryTree current = queue.pollFirst();
            swapNodes(current);
            if (current.left != null) {
                queue.addLast(current.left);
            }
            if (current.right != null) {
                queue.addLast(current.right);
            }
        }
    }

    private static void swapNodes(BinaryTree current) {
        BinaryTree leftNode = current.left;
        current.left = current.right;
        current.right = leftNode;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
