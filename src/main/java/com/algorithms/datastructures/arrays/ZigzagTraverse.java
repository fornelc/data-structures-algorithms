package com.algorithms.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

public class ZigzagTraverse {
    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        List<Integer> result = new ArrayList<>();
        int height = array.size() - 1;
        int width = array.get(0).size() - 1;
        int row = 0;
        int col = 0;
        boolean goingDown = true;

        while (!outOfBounds(height, width, row, col)) {
            result.add(array.get(row).get(col));
            if (goingDown) {
                if (col == 0 || row == height) {
                    if (row == height) {
                        col += 1;
                    } else {
                        row += 1;
                    }
                    goingDown = false;
                } else {
                    row += 1;
                    col -= 1;
                }
            } else {
                if (row == 0 || col == width) {
                    if (col == width) {
                        row += 1;
                    } else {
                        col += 1;
                    }
                    goingDown = true;
                } else {
                    row -= 1;
                    col += 1;
                }
            }
        }

        return result;
    }

    private static boolean outOfBounds(int height, int width, int row, int col) {
        return row < 0 || row > height || col < 0 || col > width;
    }
}
