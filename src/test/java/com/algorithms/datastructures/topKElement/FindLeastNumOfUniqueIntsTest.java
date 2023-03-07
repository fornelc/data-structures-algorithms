package com.algorithms.datastructures.topKElement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindLeastNumOfUniqueIntsTest {

    @Test
    public void test() {
        FindLeastNumOfUniqueInts algorithm = new FindLeastNumOfUniqueInts();
        int[] arr = {4, 3, 1, 1, 3, 3, 2};
        int k = 3;

        int result = algorithm.findLeastNumOfUniqueInts(arr, k);

        int expectedResult = 2;
        assertEquals(expectedResult, result);
    }
}
