package com.algorithms.datastructures.tree;

import com.algorithms.datastructures.utils.TreeNode;

import java.util.Stack;

public class ValidateBinarySearchTree {
    /**
     * Given a binary tree, determine if it is a valid binary search tree (BST).
     *
     * Assume a BST is defined as follows:
     *
     * - The left subtree of a node contains only nodes with keys less than the node's key.
     * - The right subtree of a node contains only nodes with keys greater than the node's key.
     * - Both the left and right subtrees must also be binary search trees.
     *
     * Solution Approach3: https://leetcode.com/problems/validate-binary-search-tree/solution/
     *
     * Time complexity : O(N) in the worst case when the tree is BST or the "bad" element is a rightmost leaf.
     * Space complexity : O(N) to keep stack.
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = Double.MIN_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // If next element in inorder traversal
            // is smaller than the previous one
            // that's not BST.
            if (root.val <= inorder)
                return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
