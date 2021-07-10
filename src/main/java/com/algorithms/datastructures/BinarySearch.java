package com.algorithms.datastructures;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int result = -1;
        int index = 0;
        for (int num : nums) {
            if (num == target) {
                result = index;
                break;
            } else if (num > target) {
                break;
            }
            index++;
        }
        return result;
    }

    public int binarySearch(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = right - 1;
            } else {
                left = left + 1;
            }
        }

        return -1;
    }

    /**
     * Exercise: https://www.algoexpert.io/questions/Binary%20Search
     *
     * Write a function that takes in a sorted array of integers as well as a target
     * integer. The function should use the Binary Search algorithm to determine if
     * the target integer is contained in the array and should return its index if it
     * is, otherwise -1
     *
     * Time Complexity: O(log n) where n is the length of your input array, and it is (log n)
     * because we are eliminating half of our input every time that we kind of traverse
     * through our input.
     *
     * Space Complexity: O(1), because you are never using additional memory to store stuff.
     *
     * Now depending of your language, you might have a space complexity of O(log n) space,
     * because of the memory usage on the call stack. You are gonna have frames on the call stack
     * that will be used up, so that's gonna take extra space.
     *
     * So that's why better to make this exercise iteratively instead of recursively so you can
     * enjoy the sort of constant space.
     *
     * @param array
     * @param target
     * @return
     */
    public int binarySearchAlgoExpert(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (array[mid] == target) {
                return mid;
            }

            if (array[mid] > target) {
                right = mid - 1;
            }
            if (array[mid] < target) {
                left = mid + 1;
            }
        }

        return -1;
    }

    public int binarySearchAlgoRecursive(int[] array, int target) {
        return binarySearchAlgoRecursiveHelper(array, target, 0, array.length -1);
    }

    private int binarySearchAlgoRecursiveHelper(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            return binarySearchAlgoRecursiveHelper(array, target, left, mid - 1);
        } else {
            return binarySearchAlgoRecursiveHelper(array, target, mid + 1, right);
        }
    }
}
