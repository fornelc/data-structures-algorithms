package com.algorithms.datastructures.arrays;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SpiralTraverseTest {
    @Test
    public void spiralTraverse_retrieveArray() {
        List<Integer> result = SpiralTraverse.spiralTraverse(new int[][]{{1,2,3,4}, {12,13,14,5},
                {11,16,15,6}, {10,9,8,7}});
        int[] primitive = result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}, primitive);
    }

    @Test
    public void spiralTraverse_retrieveArray2() {
        List<Integer> result = SpiralTraverse.spiralTraverse(new int[][]{{1,2,3,4}, {10,11,12,5},
                {9,8,7,6}});
        int[] primitive = result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, primitive);
    }

    @Test
    public void spiralTraverse_retrieveArray3() {
        List<Integer> result = SpiralTraverse.spiralTraverse(new int[][]{{1,2,3}, {12,13,4},
                {11,14,5}, {10,15,6}, {9,8,7}});
        int[] primitive = result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, primitive);
    }

    @Test
    public void spiralTraverseRecursive_retrieveArray() {
        List<Integer> result = SpiralTraverse.spiralTraverseRecursive(new int[][]{{1,2,3,4}, {12,13,14,5},
                {11,16,15,6}, {10,9,8,7}});
        int[] primitive = result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}, primitive);
    }

    @Test
    public void spiralTraverseRecursive_retrieveArray2() {
        List<Integer> result = SpiralTraverse.spiralTraverseRecursive(new int[][]{{1,2,3,4}, {10,11,12,5},
                {9,8,7,6}});
        int[] primitive = result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, primitive);
    }

    @Test
    public void spiralTraverseRecursive_retrieveArray3() {
        List<Integer> result = SpiralTraverse.spiralTraverseRecursive(new int[][]{{1,2,3}, {12,13,4},
                {11,14,5}, {10,15,6}, {9,8,7}});
        int[] primitive = result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, primitive);
    }
}
