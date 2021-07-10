package com.algorithms.datastructures.bst;

/**
 * Write a BST class for a Binary Search Tree. The class should support:
 * - Inserting values with the insert method
 * - Removing values with the remove method; this method should only remove the first instance of a given value.
 * - Searching for values with the contains method.
 *
 * Sample Usage
 * // Assume the following BST has already been created:
 *
            10
         /      \
        5       15
      /   \    /   \
     2    5  13    22
    /          \
   1          14
 *
 * // All operations below are performed sequentially.
 *
 * insert(12):    10
 *             /     \
 *            5      15
 *          /   \   /   \
 *         2     5 13   22
 *       /        /  \
 *      1        12  14
 *
 * remove (10):   12
 *             /     \
 *            5      15
 *          /   \   /   \
 *         2     5 13   22
 *       /           \
 *      1            14
 *
 * contains (15): true
 *
 * How to solve:
 * As you try to insert, find, or a remove a value into, in, or from a BST, you will have to traverse the tree's nodes.
 * The BST property allows you to eliminate half of the remaining tree at each node that you traverse:
 * if the target value is strictly smaller than a node's value,
 * then it must be (or can only be) located to the left of the node,
 * otherwise it must be (or can only be) to the right of that node.
 *
 * For insertion, add the target value to the BST once you reach a leaf (None / null) node.
 * For searching, if you reach a leaf node without having found the target value that means the value isn't in the BST.
 * For removal, consider the various cases that you might encounter:
 * the node you need to remove might have two children nodes, one, or none;
 * it might also be the root node.
 *
 * To remove the root of the node, you will need to replace it with the lesser value in the right side of the tree,
 * so the most left value in the right side, because that node is gonna be greater than any node in the left side of the tree,
 * and lesser than any value in the right side.
 *
 * Average (all 3 methods): O(log(n)) time | O(1) space - where n is the number of nodes in the BST
 * It is O(log(n)) time because when we were inserting, deleting or searching, we didn't traverse the entire tree.
 * At every node that we explored, we elminated half of the tree, half of the remaining BST.
 * Worst (all 3 methods): O(n) time | O(1) space - where n is the number of nodes in the BST
 * In the worst case you could have only one branch in the tree, because every single node is greater than its parent node.
 * So there are never any left nodes. And you could iterate through each node of the tree, to insert, search or delete.
 *
 * About the space complexity, if you gonna run your algorithm recursively, the space is gonna be O(log(n))
 * for the average case, and O(n) for the worst case.
 * This is because when you implement a recursive algorithm, when you are making an addition, search or deletion,
 * you are using up frames on the call stack, when you are calling the add, search or delete method recursively through
 * the entire tree.
 *
 * Similarly instead of calling to the complexity O(log(n)), you can call it O(d) d would be the depth of the tree,
 * meaning the length of the longest branch.
 *
 * Iteratively the space complexity is O(1) constant space.
 */
public class BinarySearchTreeConstruction {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        // We insert in the last empty node found
        public BST insert(int value) {
            BST currentNode = this;
            while (true) {
                if (value < currentNode.value) {
                    if (currentNode.left == null) {
                        currentNode.left = new BST(value);
                        break;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = new BST(value);
                        break;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
            return this;
        }

        public boolean contains(int value) {
            boolean exists = false;
            BST currentNode = this;
            while(currentNode != null) {
                if (value < currentNode.value) {
                    currentNode = currentNode.left;
                } else if (value > currentNode.value) {
                    currentNode = currentNode.right;
                } else {
                    exists = true;
                    break;
                }
            }
            return exists;
        }

        /**
         * Edges of remove method when is found the value:
         * 1. Check if the currentNode to be removed has left and right nodes. In that case you need to set its most left value from its right nodes
         * 2. Check if has no parent, then check if the left node is not null otherwise check if right node is not null
         * 3. Check if the parent left is equals to the value to be removed
         * 4. Check if the parent right is equals to the value to be removed
         * @param value
         * @return
         */
        public BST remove(int value) {
            remove(value, null);
            return this;
        }

        public void remove(int value, BST parentNode) {
            BST currentNode = this;
            while (currentNode != null) {
                if (value < currentNode.value) {
                    parentNode = currentNode;
                    currentNode = currentNode.left;
                } else if (value > currentNode.value) {
                    parentNode = currentNode;
                    currentNode = currentNode.right;
                } else {
                    if (currentNode.left != null && currentNode.right != null) {
                        // Set the node value with the lesser value on the tree, that would be the most left node from the right node
                        // as this value is gonna be greater than any node on the left and lesser than any node in the right
                        currentNode.value = currentNode.right.getMinValue();
                        // Remove from the tree the lesser node as it has just been set in the current node.
                        currentNode.right.remove(currentNode.value, currentNode);
                    } else if (parentNode == null) {
                        // If it is the root node, and it has only one node or none
                        if (currentNode.left != null) {
                            currentNode = currentNode.left;
                            currentNode.right = currentNode.left.right;
                            // We set at the end the left node, because we use it to set first the current node and the current node right node
                            currentNode.left = currentNode.left.left;
                        } else if (currentNode.right != null){
                            currentNode = currentNode.right;
                            currentNode.left = currentNode.right.left;
                            currentNode.right = currentNode.right.right;
                        } else {
                            // Do nothing
                        }
                    } else if (parentNode.left == currentNode) {
                        // We set the left node of the parent node, with the left node of the current node if the left node is not null
                        // otherwise we set it with the right node
                        parentNode.left = currentNode.left != null ? currentNode.left : currentNode.right;
                    } else if (parentNode.right.value == value) {
                        parentNode.right = currentNode.left != null ? currentNode.left : currentNode.right;
                    }
                    break;
                }
            }
        }

        private int getMinValue() {
            BST currentNode = this;
            while (true) {
                if (currentNode.left == null) {
                    return currentNode.value;
                } else {
                    currentNode = currentNode.left;
                }
            }
        }
    }
}
