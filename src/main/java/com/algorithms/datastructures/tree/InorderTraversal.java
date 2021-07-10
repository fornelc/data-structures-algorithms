package com.algorithms.datastructures.tree;

import com.algorithms.datastructures.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    /**
     * Given the root of a binary tree, return the inorder traversal of its nodes' values.
     * Solution: https://leetcode.com/problems/binary-tree-inorder-traversal/solution/
     *
     * Time complexity : O(n). The time complexity is O(n) because the recursive function is T(n) = 2 . T(n/2)+1
     * Space complexity : The worst case space required is O(n), and in the average case it's O(log n) where n is number of nodes.
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList< >();
        if (root != null) {
            helper(root, res);
        }
        return res;
    }

    /**
     * Time complexity : O(n).
     * Space complexity : O(n).
     * @param root
     * @return
     */
    public List <Integer> inorderTraversalApproach2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    private void helper(TreeNode root, List <Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }
}
