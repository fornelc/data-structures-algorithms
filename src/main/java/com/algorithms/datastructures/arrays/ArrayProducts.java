package com.algorithms.datastructures.arrays;

/**
 * https://www.algoexpert.io/questions/Array%20Of%20Products
 * Write a function that takes in a non-empty array of integers and returns an
 * array of the same length, where each element in the output array is equal to
 * the product of every other number in the input array.
 *
 * Sample Input
 * array = [5,1,4,2]
 *
 * Sample Output
 * [8, 40, 10, 20]
 * // 8 is equal to 1 x 4 x 2
 * // 40 is equal to 5 x 4 x 2
 * // 10 is equal to 5 x 1 x 2
 * // 20 is equal to 5 x 1 x 4
 *
 * How to solve:
 * For each index in the input array, try calculating the product of every element to the left
 * and the product of every element to the right.
 * You can do this with two loops through the array:
 * one from left to right to store the products at the left of each element,
 * and one from right to left to store the products at the right of each element.
 *
 * O(n) time | O(n) space - where n is the length of the input array.
 * The space is O(n), we only have three arrays all of size n, so 3n gets reduced to O(n).
 * Time complexity is also O(3n) which would be reduced to O(n) as well. We are doing three
 * traversals through the array. One from left to right to fill up the left products array,
 * one from right to left to fill up the right products array, and then one through both of
 * the arrays where we access both elements simultaneously multiply them together and fill up
 * our output array.
 *
 * To make it better the algorithm we can eliminate the two arrays, and calculate the products
 * on the fly in our output array. So we can eliminate two size n arrays from our solution.
 * And it would be only two linear loops, one left to right, and one right to left.
 */
public class ArrayProducts {
    public static int[] arrayOfProducts(int[] array) {
        int[] result = new int[array.length];

        // Calculate left side products
        int leftProduct = 1;
        for (int i = 0; i < array.length; i++) {
            result[i] = leftProduct;
            leftProduct *= array[i];
        }

        // Calculate right side products
        int rightProduct = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= array[i];
        }

        return result;
    }
}
