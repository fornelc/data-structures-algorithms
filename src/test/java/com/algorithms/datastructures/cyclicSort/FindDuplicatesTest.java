package com.algorithms.datastructures.cyclicSort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindDuplicatesTest {

    // Test if the algorithm returns an empty list when there are no duplicates
    @Test
    public void testFindDuplicatesWithNoDuplicates() {
        int[] inputArray = {1, 2, 3, 4};
        List<Integer> expectedList = new ArrayList<>();
        List<Integer> actualList = new FindDuplicates().findDuplicates(inputArray);
        assertEquals(expectedList, actualList);
    }

    // Test if the algorithm returns a list with one duplicate when there is one duplicate
    @Test
    public void testFindDuplicatesWithOneDuplicate() {
        int[] inputArray = {1, 2, 3, 3};
        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(3);
        List<Integer> actualList = new FindDuplicates().findDuplicates(inputArray);
        assertEquals(expectedList, actualList);
    }

    // Test if the algorithm returns a list with multiple duplicates when there are multiple duplicates
    @Test
    public void testFindDuplicatesWithMultipleDuplicates() {
        int[] inputArray = {1, 2, 2 ,3 ,4 ,5 ,5};
        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(2);
        expectedList.add(5);
        List<Integer> actualList = new FindDuplicates().findDuplicates(inputArray);
        assertEquals(expectedList ,actualList );
    }
}
