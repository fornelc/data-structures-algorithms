package com.algorithms.datastructures.bst;

/**
 * https://www.algoexpert.io/questions/Validate%20BST
 * Write a function that takes in a potentially invalid Binary Search Tree (BST)
 * and returns a boolean representing whether the BST is valid.
 *
 * Sample Input:
 * tree = 10
 *       / \
 *      5 15
 *    / \ / \
 *   2 5 13 22
 *   / \
 *  1 14
 *
 * Sample Output: true
 *
 * How to solve:
 *
 * Every node in the BST has a maximum possible value and a minimum possible value.
 * In other words, the value of any given node in the BST must be strictly smaller than some value
 * (the value of its closest right parent) and must be greater than or equal to some other value
 * (the value of its closest left parent).
 *
 * Validate the BST by recursively calling the validateBst function on every node,
 * passing in the correct maximum and minimum possible values to each.
 * Initialize those values to be -Infinity and +Infinity.
 *
 * Optimal Space & Time Complexity
 * O(n) time | O(d) space - where n is the number of nodes in the BST and d is the depth (height) of the BST
 * It is O(n) because we are traversing every single node in the tree,
 * and every computation that we do on a given node is a constant time computation.
 * Like checking that the node's value is between the minimum value and the maximum value,
 * that's a constant time operation.
 *
 * About the space, we are not using any additional space, in terms of variables that we're storing.
 * But we're using space on the call stack, because we're calling recursively the helper method on all of our subtrees.
 * And it's only once these functions resolve that we can go back up and clear space on the call stack.
 * So that's why it is O(d), and the depth of the tree in the length of the longest branch in the BST.
 * It is worth it pointing out that if the tree only had one branch, then the space complexity would be O(n),
 * as then we would be visiting each node in the BST.
 */
public class ValidateBST {
    public static boolean validateBst(BST tree) {
        return validateBSTHelper(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validateBSTHelper(BST tree, int minValue, int maxValue) {
        if (tree == null) {
            return true;
        }
        if (tree.value < minValue || tree.value >= maxValue) {
            return false;
        }
        boolean leftBranch = validateBSTHelper(tree.left, minValue, tree.value);
        return leftBranch && validateBSTHelper(tree.right, tree.value, maxValue);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
