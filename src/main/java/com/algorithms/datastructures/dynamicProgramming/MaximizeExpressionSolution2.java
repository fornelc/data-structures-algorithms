package com.algorithms.datastructures.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximizeExpressionSolution2 {
    public int maximizeExpression(int[] array) {
        if (array.length < 4) {
            return 0;
        }

        List<Integer> aArray = new ArrayList<>(Arrays.asList(array[0]));
        List<Integer> aMinusBArray = new ArrayList<>(Arrays.asList(Integer.MIN_VALUE));
        List<Integer> aMinusBPlusCArray = new ArrayList<>(Arrays.asList(Integer.MIN_VALUE, Integer.MIN_VALUE));
        List<Integer> aMinusBPlusCMinusDArray = new ArrayList<>(Arrays.asList(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE));

        for (int i = 1; i < array.length; i++) {
            int maxValue = Math.max(aArray.get(i - 1), array[i]);
            aArray.add(i,maxValue);
        }

        for (int i = 1; i < array.length; i++) {
            int maxValue = Math.max(aMinusBArray.get(i - 1), aArray.get(i - 1) - array[i]);
            aMinusBArray.add(i, maxValue);
        }

        for (int i = 2; i < array.length; i++) {
            int maxValue = Math.max(aMinusBPlusCArray.get(i - 1), aMinusBArray.get(i - 1) + array[i]);
            aMinusBPlusCArray.add(i, maxValue);
        }

        for (int i = 3; i < array.length; i++) {
            int maxValue = Math.max(aMinusBPlusCMinusDArray.get(i - 1), aMinusBPlusCArray.get(i - 1) - array[i]);
            aMinusBPlusCMinusDArray.add(i, maxValue);
        }

        return aMinusBPlusCMinusDArray.get(aMinusBPlusCMinusDArray.size() - 1);
    }
}
