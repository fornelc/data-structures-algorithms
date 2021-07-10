package com.algorithms.datastructures;

import java.util.ArrayList;
import java.util.List;

public class ProductSum {
    /**
     * https://www.algoexpert.io/questions/Product%20Sum
     *
     * Write a function that takes in a "special" array and returns its product sum.
     *
     * Example:
     * Array = [5, 2, [7, -1], 3, [6, [-13, 8], 4]]
     * Output = 12 // calculated as: 5 + 2 + 2 * (7 - 1) + 3 + 2 * (6 + 3 * (-13 + 8) + 4)
     *
     * Time O(N) | Space O(d)
     *
     * The time complexity would take in account each array and each number,
     * so in the example the time complexity would be O(12)
     *
     * The space complexity would be incremented each time we call recursively the helper method,
     * so in the example the space would be O(3)
     *
     */
    public int productSum(List<Object> array) {
        return helper(array, 1);
    }

    private int helper(List<Object> array, Integer multiplier) {
        Integer productSum = 0;
        for (Object object : array) {
            if (object instanceof Integer) {
                productSum += (Integer) object;
            } else if (object instanceof ArrayList) {
                productSum += helper((ArrayList)object, multiplier + 1);
            }
        }
        return productSum * multiplier;
    }
}
