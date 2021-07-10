package com.algorithms.datastructures.heap;

import java.util.PriorityQueue;

public class KthLargestElementArray {
    /**
     * Find the kth largest element in an unsorted array.
     * Note that it is the kth largest element in the sorted order, not the kth distinct element.
     *
     * Example:
     * Input: [3,2,1,5,6,4] and k = 2
     * Output: 5
     *
     * Solution: https://leetcode.com/problems/kth-largest-element-in-an-array/solution/
     *
     * The time complexity of adding an element in a heap of size k is O(log k),
     * and we do it N times that means O(N log k) time complexity for the algorithm.
     *
     * Space complexity : O(k) to store the heap elements.
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        // keep k largest elements in the heap
        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // output
        return heap.poll();
    }
}
