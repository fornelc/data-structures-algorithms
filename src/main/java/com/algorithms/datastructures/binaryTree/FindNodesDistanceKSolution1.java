package com.algorithms.datastructures.binaryTree;

import java.util.*;

public class FindNodesDistanceKSolution1 {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    class Pair<U, V> {
        public U node;
        public V distance;

        public Pair(U node, V distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        if (tree == null) {
            return new ArrayList<>();
        }
        Map<Integer, BinaryTree> valuesAndParents = new HashMap<>();
        buildMapValuesAndParents(tree, null, valuesAndParents);
        BinaryTree targetNode = getTargetNode(tree, valuesAndParents, target);

        return breadthFirstSearch(targetNode, k, valuesAndParents);
    }

    private ArrayList<Integer> breadthFirstSearch(BinaryTree targetNode, int k,
                                                  Map<Integer, BinaryTree> valuesAndParents) {
        Queue<Pair<BinaryTree, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(targetNode, 0));
        Set<Integer> seen = new HashSet<>();
        while (queue.size() > 0) {
            Pair<BinaryTree, Integer> pair = queue.poll();
            BinaryTree currentNode = pair.node;
            Integer distance = pair.distance;

            if (distance == k) {
                ArrayList<Integer> result = new ArrayList<>();
                result.add(currentNode.value);
                for (Pair<BinaryTree, Integer> nodesAtDistance : queue) {
                    result.add(nodesAtDistance.node.value);
                }
                return result;
            }
            seen.add(currentNode.value);

            List<BinaryTree> nodesToBeAdded = retrieveNodesToBeAdded(valuesAndParents, currentNode);

            for (BinaryTree binaryTree : nodesToBeAdded) {
                if (binaryTree == null) {
                    continue;
                }
                if (seen.contains(binaryTree.value)) {
                    continue;
                }
                queue.add(new Pair<>(binaryTree, distance + 1));
            }
        }

        return new ArrayList<>();
    }

    private List<BinaryTree> retrieveNodesToBeAdded(Map<Integer, BinaryTree> valuesAndParents, BinaryTree currentNode) {
        List<BinaryTree> nodesToBeAdded = new ArrayList<>();
        nodesToBeAdded.add(valuesAndParents.get(currentNode.value));
        nodesToBeAdded.add(currentNode.left);
        nodesToBeAdded.add(currentNode.right);
        return nodesToBeAdded;
    }

    private BinaryTree getTargetNode(BinaryTree rootNode, Map<Integer, BinaryTree> valuesAndParents, int target) {
        BinaryTree parentNode = valuesAndParents.get(target);
        if (parentNode == null) {
            return rootNode;
        }

        if (parentNode.left != null && parentNode.left.value == target) {
            return parentNode.left;
        }

        return parentNode.right;
    }

    private void buildMapValuesAndParents(BinaryTree tree,
                                          BinaryTree parent,
                                          Map<Integer, BinaryTree> valuesAndParents) {
        if (tree != null) {
            valuesAndParents.put(tree.value, parent);
            buildMapValuesAndParents(tree.left, tree, valuesAndParents);
            buildMapValuesAndParents(tree.right, tree, valuesAndParents);
        }
    }
}
