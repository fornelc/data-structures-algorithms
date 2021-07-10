package com.algorithms.datastructures.linkedLists;

/**
 * Source: https://www.algoexpert.io/questions/Remove%20Duplicates%20From%20Linked%20List
 *
 * How to solve:
 *
 * The brute-force approach to this problem is to use a hash table
 * or a set to keep track of all node values that exist while traversing the linked list
 * and to simply remove nodes that have a value that already exists.
 *
 * As a better solution without using an auxiliary data structure, since the linked list's nodes are sorted,
 * you can loop through them and, at each iteration,
 * simply remove all successive nodes that have the same value as the current node.
 * For each node, change its next pointer to the next node in the linked list that has a different value.
 * This will remove all duplicate-value nodes.
 *
 * Space & Time complexity
 *
 * O(n) time | O(1) space - where n is the number of nodes in the Linked List.
 *
 * We get this O(n) time from the fact that we look through all of the nodes exactly one time.
 * We just do one pass through the linked list.
 * And then we know if there's any duplicate values or not and why we would have removed them.
 */
public class RemoveDuplicatesFromLinkedList {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList current = linkedList;
        while (current != null) {
            LinkedList nextLinkedList = current.next;
            while (nextLinkedList != null && nextLinkedList.value == current.value) {
                nextLinkedList = nextLinkedList.next;
            }
            current.next = nextLinkedList;
            current = nextLinkedList;
        }
        return linkedList;
    }
}
