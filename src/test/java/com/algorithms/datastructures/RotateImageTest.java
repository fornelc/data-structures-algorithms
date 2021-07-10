package com.algorithms.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotateImageTest {
    private RotateImage sut;

    @BeforeEach
    public void setUp() {
        sut = new RotateImage();
    }

    @Test
    public void rotate() {
        int[][] array = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        sut.rotate(array);
        assertEquals(7, array[0][0]);
    }
}
