package com.algorithms.datastructures.tree;

import com.algorithms.datastructures.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    /**
     * Given a binary tree, return the zigzag level order traversal of its nodes' values.
     * (ie, from left to right, then right to left for the next level and alternate between).
     *
     * For example:
     * Given binary tree [3,9,20,null,null,15,7],
     * return its zigzag level order traversal as:
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     *
     * Solution Approach2: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/solution/
     *
     * Time Complexity: O(N), where N is the number of nodes in the tree.
     *  * Same as the previous BFS approach, we visit each node once and only once.
     *
     * Space Complexity: O(H), where H is the height of the tree,
     * i.e. the number of levels in the tree, which would be roughly log_2 N.
     *  * Unlike the BFS approach, in the DFS approach, we do not need to maintain the node_queue data structure for the traversal.
     *  * However, the function recursion would incur additional memory consumption on the function call stack.
     *  As we can see, the size of the call stack for any invocation of DFS(node, level)
     *  would be exactly the number of level that the current node resides on.
     *  Therefore, the space complexity of our DFS algorithm is O(log_2 N)
     *  which is much better than the BFS approach.
     */
    protected void DFS(TreeNode node, int level, List<List<Integer>> results) {
        if (level >= results.size()) {
            LinkedList<Integer> newLevel = new LinkedList<Integer>();
            newLevel.add(node.val);
            results.add(newLevel);
        } else {
            if (level % 2 == 0)
                results.get(level).add(node.val);
            else
                results.get(level).add(0, node.val);
        }

        if (node.left != null) DFS(node.left, level + 1, results);
        if (node.right != null) DFS(node.right, level + 1, results);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        DFS(root, 0, results);
        return results;
    }
}
