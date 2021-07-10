package com.algorithms.datastructures.linkedLists;

/**
 * Source: https://www.algoexpert.io/questions/Linked%20List%20Construction
 *
 * How to solve:
 *
 * When dealing with linked lists, it's very important to keep track of pointers on nodes
 * (i.e., the "next" and "prev" properties on the nodes).
 * For instance, if you're inserting a node in a linked list,
 * but that node is already located somewhere else in the linked list (in other words, if you're moving a node),
 * it's crucial to completely update the pointers of the adjacent nodes of the node being moved
 * before updating the node's own pointers.
 * The order in which you update nodes' pointers will make or break your algorithm.
 *
 * Realize that the insertBefore() and insertAfter() methods can be used to implement the setHead(),
 * setTail(), and insertAtPosition() methods; making the insertBefore()
 * and insertAfter() methods as robust as possible will simplify your code for the other methods.
 * Make sure to take care of edge cases involving inserting nodes before the head of the linked list
 * or inserting nodes after the tail of the linked list.
 *
 * Realize that the remove() method can be used to implement the removeNodesWithValue() method
 * as well as parts of the insertBefore() and insertAfter() methods;
 * make sure that the remove() method handles edge cases regarding the head and the tail.
 *
 * Space & Time complexity
 *
 * setHead, setTail, insertBefore, insertAfter, and remove: O(1) time | O(1) space
 * insertAtPosition: O(p) time | O(1) space - where p is input position
 * removeNodesWithValue, containsNodeWithValue: O(n) time | O(1) space - where n is the number of nodes in the linked list
 */
public class LinkedListConstruction {
    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            if (head == null) {
                head = node;
                tail = node;
                return;
            }
            insertBefore(head, node);
        }

        public void setTail(Node node) {
            if (tail == null) {
                setHead(node);
                return;
            }
            insertAfter(tail, node);
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            if (head == nodeToInsert && tail == nodeToInsert) {
                return;
            }
            remove(nodeToInsert);
            nodeToInsert.next = node;
            nodeToInsert.prev = node.prev;
            if (node.prev == null) {
                head = nodeToInsert;
            } else {
                node.prev.next = nodeToInsert;
            }
            node.prev = nodeToInsert;
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            if (head == nodeToInsert && tail == nodeToInsert) {
                return;
            }
            remove(nodeToInsert);
            nodeToInsert.prev = node;
            nodeToInsert.next = node.next;
            if (node.next == null) {
                tail = nodeToInsert;
            } else {
                node.next.prev = nodeToInsert;
            }
            node.next = nodeToInsert;
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            if (position == 1) {
                setHead(nodeToInsert);
                return;
            }
            Node node = head;
            int counter = 1;
            while (node != null) {
                if (counter == position) {
                    insertBefore(node, nodeToInsert);
                    return;
                }
                node = node.next;
                counter++;
            }
            setTail(nodeToInsert);
        }

        public void removeNodesWithValue(int value) {
            Node node = head;
            while (node != null) {
                Node nodeToRemove = node;
                node = node.next;
                if (nodeToRemove.value == value) {
                    remove(nodeToRemove);
                }
            }
        }

        public void remove(Node node) {
            if (node == head) {
                head = head.next;
            }
            if (node == tail) {
                tail = tail.prev;
            }
            unboundNode(node);
        }

        public boolean containsNodeWithValue(int value) {
            Node node = head;
            while (node != null) {
                if (value != node.value) {
                    node = node.next;
                } else {
                    break;
                }
            }
            return node != null;
        }

        private void unboundNode(Node node) {
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            node.next = null;
            node.prev = null;
        }
    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
