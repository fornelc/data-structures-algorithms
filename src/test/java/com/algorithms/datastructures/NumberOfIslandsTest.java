package com.algorithms.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfIslandsTest {
    private NumberOfIslands sut;

    @BeforeEach
    public void setUp() {
        sut = new NumberOfIslands();
    }

    @Test
    public void numIslands() {
        assertEquals(3, sut.numIslands(buildGrid()));
    }

    private char[][] buildGrid() {
        char[][] grid = new char[4][3];
        grid[0][0] = '1';
        grid[0][1] = '1';
        grid[0][2] = '1';
        grid[1][0] = '0';
        grid[1][1] = '1';
        grid[1][2] = '0';
        grid[2][0] = '1';
        grid[2][1] = '0';
        grid[2][2] = '0';
        grid[3][0] = '1';
        grid[3][1] = '0';
        grid[3][2] = '1';

        return grid;
    }
}
