package com.algorithms.datastructures.stacks;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SunsetViewsSolution1Test {
    @Test
    public void TestCase1() {
        int[] buildings = new int[] {3, 5, 4, 4, 3, 1, 3, 2};
        String direction = "EAST";
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(3);
        expected.add(6);
        expected.add(7);
        var actual = new SunsetViewsSolution1().sunsetViews(buildings, direction);
        assertTrue(expected.equals(actual));
    }
}
