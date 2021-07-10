package com.algorithms.datastructures;

import com.algorithms.datastructures.utils.ListNode;

public class RemoveNthFromEnd {

    /**
     * Time : O(n) - Space : O(n)
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        ListNode p= head, curr = dummyHead;
        int i = 0;
        while (p != null) {
            p = p.next;
            i++;
        }

        int index = i - n;

        p = head;

        i = 0;
        while (p != null) {
            if (i != index) {
                curr.next = new ListNode(p.val);
                curr = curr.next;
            }
            if (p != null) {
                p = p.next;
            }
            i++;
        }

        return dummyHead.next;
    }

    /**
     * Solution explained: https://leetcode.com/problems/remove-nth-node-from-end-of-list/solution/
     * Time : O(n) - Space : O(1)
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndApproach1(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length  = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEndApproach2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
