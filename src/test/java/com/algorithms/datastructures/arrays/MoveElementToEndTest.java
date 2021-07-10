package com.algorithms.datastructures.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveElementToEndTest {

    @Test
    public void moveElementToEndAlgoSolution_returnArray() {
        List<Integer> result = MoveElementToEnd.moveElementToEndAlgoSolution(Arrays.asList(2,1,2,2,2,3,4,2), 2);
        assertEquals(2, result.get(7).intValue());
        assertEquals(2, result.get(6).intValue());
        assertEquals(2, result.get(5).intValue());
        assertEquals(2, result.get(4).intValue());
        assertEquals(2, result.get(3).intValue());
        assertEquals(3, result.get(2).intValue());
        assertEquals(1, result.get(1).intValue());
        assertEquals(4, result.get(0).intValue());
    }

    @Test
    public void moveElementToEnd_returnArray() {
        List<Integer> result = MoveElementToEnd.moveElementToEnd(Arrays.asList(2,1,2,2,2,3,4,2), 2);
        assertEquals(2, result.get(7).intValue());
        assertEquals(2, result.get(6).intValue());
        assertEquals(2, result.get(5).intValue());
        assertEquals(2, result.get(4).intValue());
        assertEquals(2, result.get(3).intValue());
        assertEquals(3, result.get(2).intValue());
        assertEquals(1, result.get(1).intValue());
        assertEquals(4, result.get(0).intValue());
    }
}
