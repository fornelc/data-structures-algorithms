package com.algorithms.datastructures.bst;

import java.util.ArrayList;
import java.util.List;

public class SameBSTsSolution1 {
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne.size() != arrayTwo.size()) {
            return false;
        }

        if (arrayOne.size() == 0 && arrayTwo.size() == 0) {
            return true;
        }

        if (arrayOne.get(0) != arrayTwo.get(0)) {
            return false;
        }

        // O(4N) and you can remove the 4, and you do this N times, and you've got O(n^2) time
        List<Integer> leftOne = getSmaller(arrayOne);
        List<Integer> leftTwo = getSmaller(arrayTwo);
        List<Integer> rightOne = getBiggerOrEqual(arrayOne);
        List<Integer> rightTwo = getBiggerOrEqual(arrayTwo);

        return sameBsts(leftOne, leftTwo) && sameBsts(rightOne, rightTwo);
    }

    private static List<Integer> getSmaller(List<Integer> numbers) {
        List<Integer> smaller = new ArrayList<>();
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < numbers.get(0)) {
                smaller.add(numbers.get(i));
            }
        }
        return smaller;
    }

    private static List<Integer> getBiggerOrEqual(List<Integer> numbers) {
        List<Integer> biggerOrEqual = new ArrayList<>();
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) >= numbers.get(0)) {
                biggerOrEqual.add(numbers.get(i));
            }
        }
        return biggerOrEqual;
    }

}
