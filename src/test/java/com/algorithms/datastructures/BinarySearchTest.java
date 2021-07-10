package com.algorithms.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {

    private BinarySearch sut;

    @BeforeEach
    public void setUp() {
        sut = new BinarySearch();
    }

    @Test
    public void search() {
        assertEquals(sut.search(new int[]{-1,0,3,5,9,12}, 2), -1);
        assertEquals(sut.search(new int[]{-1,0,3,5,9,12}, 9), 4);
    }

    @Test
    public void binarySearch() {
        assertEquals(sut.binarySearch(new int[]{-1,0,3,5,9,12}, 2), -1);
        assertEquals(sut.binarySearch(new int[]{-1,0,3,5,9,12}, 0), 1);
    }

    @Test
    public void binarySearchAlgoExpert_findNumber() {
        assertEquals(-1, sut.binarySearchAlgoExpert(new int[]{-1,0,3,5,9,12}, 2));
        assertEquals(0, sut.binarySearchAlgoExpert(new int[]{-1,0,3,5,9,12}, 1));
    }

    @Test
    public void binarySearchAlgoExpertRecursive_findNumber() {
        assertEquals(sut.binarySearchAlgoRecursive(new int[]{-1,0,3,5,9,12}, 2), -1);
        assertEquals(sut.binarySearchAlgoRecursive(new int[]{-1,0,3,5,9,12}, 0), 1);
    }
}
