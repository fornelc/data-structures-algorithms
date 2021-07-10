package com.algorithms.datastructures.tree;


import com.algorithms.datastructures.utils.TreeNode;

public class InsertIntoBinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
           root.val = val;
        }
        // The changes done in currentNode will be applied in root too
        TreeNode currentNode = root;
        while(true) {
            if (currentNode.val <= val) {
                if (currentNode.right != null) {
                    currentNode = currentNode.right;
                } else {
                    currentNode.right = new TreeNode(val);
                    break;
                }
            } else {
                if (currentNode.left != null) {
                    currentNode = currentNode.left;
                } else {
                    currentNode.left = new TreeNode(val);
                    break;
                }
            }
        }

        return root;
    }

    public TreeNode iterativeInsertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val <= val) {
            root.right = iterativeInsertIntoBST(root.right, val);
        } else {
            root.left = iterativeInsertIntoBST(root.left, val);
        }

        return root;
    }

}
