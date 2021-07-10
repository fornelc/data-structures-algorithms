package com.algorithms.datastructures.linkedLists;

/**
 * Source: https://www.algoexpert.io/questions/Remove%20Kth%20Node%20From%20End
 *
 * How to solve:
 *
 * Since you are given a Singly Linked List, you do not have access to any of the list's nodes' previous nodes.
 * Thus, traversing the entire list and then counting k nodes back isn't an option.
 *
 * Initialize two variables pointing to the first node in the list.
 * Traverse k nodes in the list, updating the second variable at every node
 * (that is, take k steps with the second variable). Then, traverse the remainder of the list,
 * this time updating both the second and the first variables
 * (that is take as many steps with the first variable as the number of steps between the kth node from the start
 * and the end of the list). Once you reach the end of the list,
 * the first variable should point to the kth node from the end.
 *
 * Space & Time complexity
 *
 * O(n) time | O(1) space - where n is the number of nodes in the Linked List
 *
 * It is O(n) time because with your second pointer you traverse a total of n nodes.
 * And the fact that you moved your first pointer simultaneously afterwards,
 * doesn't add any sort of time complexity.
 * And removing the node from the list also doesn't take anything, it runs in constant time.
 *
 * It is O(1) space because all you're doing is moving the pointers, keeping track of nodes at the pointers,
 * keeping track of the counter variable. But overall you are not storing much else.
 */
public class RemoveKthNodeFromEnd {
    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        int counter = 1;
        LinkedList firstPointer = head;
        LinkedList secondPointer = head;
        while (counter <= k) {
            secondPointer = secondPointer.next;
            counter++;
        }

        if (secondPointer == null) {
            head.value = head.next.value;
            head.next = head.next.next;
            return;
        }

        while (secondPointer.next != null) {
            secondPointer = secondPointer.next;
            firstPointer = firstPointer.next;
        }

        firstPointer.next = firstPointer.next.next;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
