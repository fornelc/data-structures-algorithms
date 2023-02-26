package com.algorithms.datastructures.cyclicSort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindDisappearedNumbersTest {

    @Test
    public void testFindDisappearedNumbers() {
        // Arrange
        FindDisappearedNumbers solution = new FindDisappearedNumbers();
        int[] nums1 = {4, 3, 2, 7, 8, 2 ,3 ,1};
        int[] nums2 = {1 ,1};
        int[] nums3 = {5 ,4 ,6 ,7 ,9 ,3 ,10 ,9 ,5 ,6};
        int[] nums4 = {1};

        // Act
        List<Integer> result1 = solution.findDisappearedNumbers(nums1);
        List<Integer> result2 = solution.findDisappearedNumbers(nums2);
        List<Integer> result3 = solution.findDisappearedNumbers(nums3);
        List<Integer> result4 = solution.findDisappearedNumbers(nums4);

        // Assert
        assertEquals(Arrays.asList(5, 6) ,result1);
        assertEquals(Arrays.asList(2) ,result2);
        assertEquals(Arrays.asList(1, 2, 8) ,result3);
        assertEquals(Collections.emptyList() ,result4);
    }
}
