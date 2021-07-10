package com.algorithms.datastructures.bst;

/**
 * To see the description of this exercise go to BynarySearchTree
 *
 * Average for the three methods: Time O(log(n)) | Space O(log(n))
 * Worst for the three methods: Time O(n) | Space O(n)
 */
public class BinarySearchTreeConstructionRecursive {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            if (value < this.value) {
                if (this.left != null) {
                    left.insert(value);
                } else {
                    left = new BST(value);
                }
            } else {
                if (this.right != null) {
                    right.insert(value);
                } else {
                    right = new BST(value);
                }
            }
            return this;
        }

        public boolean contains(int value) {
            if (value < this.value) {
                if (left != null) {
                    return left.contains(value);
                }
            } else if (value > this.value) {
                if (right != null) {
                    return right.contains(value);
                }
            } else {
                return true;
            }
            return false;
        }

        public BST remove(int value) {
            remove(value, null);
            return this;
        }

        private void remove(int value, BST parentNode) {
            if (value < this.value) {
                if (left != null) {
                    left.remove(value, this);
                }
            } else if (value > this.value) {
                if (right != null) {
                    right.remove(value, this);
                }
            } else {
                if (this.left != null && this.right != null) {
                    this.value = right.getMinValue();
                    this.right.remove(this.value, this);
                } else if (parentNode == null) {
                    if (this.left != null) {
                        this.value = this.left.value;
                        this.right = this.left.right;
                        this.left = this.left.left;
                    } else if (this.right != null) {
                        this.value = this.right.value;
                        this.left = this.right.left;
                        this.right = this.right.right;
                    } else {
                        // Do nothing
                    }
                } else if (parentNode.left == this) {
                    parentNode.left = this.left != null ? this.left : this.right;
                } else if (parentNode.right == this) {
                    parentNode.right = this.left != null ? this.left : this.right;
                }
            }
        }

        private int getMinValue() {
            if (this.left == null) {
                return this.value;
            } else {
                return this.left.getMinValue();
            }
        }
    }
}
