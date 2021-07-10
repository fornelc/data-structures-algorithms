package com.algorithms.datastructures.tree;

import com.algorithms.datastructures.utils.TreeNode;

public class LowestCommonAncestorBinaryTree {
    private TreeNode ans;

    public LowestCommonAncestorBinaryTree() {
        // Variable to store LCA node.
        this.ans = null;
    }

    private boolean recurseTree(TreeNode currentNode, int p, int q) {

        // If reached the end of a branch, return false.
        if (currentNode == null || ans != null) {
            return false;
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        // Right Recursion
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        // If the current node is one of p or q
        int mid = (currentNode.val == p || currentNode.val == q) ? 1 : 0;


        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }

    /**
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
     * According to the definition of LCA on Wikipedia:
     * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T
     * that has both p and q as descendants (where we allow a node to be a descendant of itself).”
     *
     * Solution Approach1: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/
     *
     * Time Complexity: O(N), where N is the number of nodes in the binary tree.
     * In the worst case we might be visiting all the nodes of the binary tree.
     *
     * Space Complexity: O(N). This is because the maximum amount of space utilized
     * by the recursion stack would be N since the height of a skewed binary tree could be N.
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        // Traverse the tree
        this.recurseTree(root, p, q);
        return this.ans;
    }
}
