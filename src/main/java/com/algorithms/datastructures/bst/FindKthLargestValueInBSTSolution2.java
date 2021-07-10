package com.algorithms.datastructures.bst;

public class FindKthLargestValueInBSTSolution2 {
    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    class TreeNodeTrack {
        public int nodesVisited;
        public int lastNodeVisited;

        TreeNodeTrack(int nodesVisited, int lastNodeVisited) {
            this.nodesVisited = nodesVisited;
            this.lastNodeVisited = lastNodeVisited;
        }
    }

    public int findKthLargestValueInBst(BST tree, int k) {
        TreeNodeTrack treeNodeTrack = new TreeNodeTrack(0, 0);
        reverseInOrderTraversal(treeNodeTrack, tree, k);
        return treeNodeTrack.lastNodeVisited;
    }

    private void reverseInOrderTraversal(TreeNodeTrack treeNodeTrack, BST node, int k) {
        if (node == null || treeNodeTrack.nodesVisited >= k) {
            return;
        }

        reverseInOrderTraversal(treeNodeTrack, node.right, k);
        // If we have visited k nodes, we don't wanna change the latest visited node value.
        // And we also don't want to continue traversing to the left
        // because we know we have already found the Kth largest node.
        // That is why we have this check
        if (treeNodeTrack.nodesVisited < k) {
            treeNodeTrack.nodesVisited++;
            treeNodeTrack.lastNodeVisited = node.value;
            reverseInOrderTraversal(treeNodeTrack, node.left, k);
        }
    }
}
