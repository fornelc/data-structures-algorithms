package com.algorithms.datastructures.binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxPathSum {
    public static int maxPathSum(BinaryTree tree) {
        List<Integer> maxSumArray = findMaxPathSum(tree);
        return maxSumArray.get(1);
    }

    private static List<Integer> findMaxPathSum(BinaryTree tree) {
        if (tree == null) {
            return new ArrayList<>(Arrays.asList(0, Integer.MIN_VALUE));
        }

        List<Integer> leftMaxSumArray = findMaxPathSum(tree.left);
        Integer leftMaxSumAsBranch = leftMaxSumArray.get(0);
        Integer leftMaxPathSum = leftMaxSumArray.get(1);

        List<Integer> rightMaxSumArray = findMaxPathSum(tree.right);
        Integer rightMaxSumAsBranch = rightMaxSumArray.get(0);
        Integer rightMaxPathSum = rightMaxSumArray.get(1);

        Integer value = tree.value;

        Integer maxChildSumAsBranch = Math.max(leftMaxSumAsBranch, rightMaxSumAsBranch);
        Integer maxSumAsBranch = Math.max(maxChildSumAsBranch + value, value);
        Integer maxSumAsRootNode = Math.max(leftMaxSumAsBranch + value + rightMaxSumAsBranch, maxSumAsBranch);
        Integer maxPathSum = Math.max(leftMaxPathSum, Math.max(rightMaxPathSum, maxSumAsRootNode));

        return new ArrayList<>(Arrays.asList(maxSumAsBranch, maxPathSum));
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
