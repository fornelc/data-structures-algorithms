package com.algorithms.datastructures.recursion;

import java.util.*;

/**
 * Sudoku solver - Time Complexity O(1) - Space Complexity O(1) - This time and space complexity because
 * the board input is going to have always the same size,
 * so in terms of time and space complexity this is translated to constant.
 */
public class SolveSudoku {

    public ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
        solveBoard(0, 0, board);
        return board;
    }

    private boolean solveBoard(int row, int col, ArrayList<ArrayList<Integer>> board) {
        int currentRow = row;
        int currentCol = col;

        if (currentCol == board.get(currentRow).size()){
            if (currentRow == board.size() - 1) {
                return true;
            }
            currentCol = 0;
            currentRow++;
        }

        if (board.get(currentRow).get(currentCol) == 0) {
            return tryToFindDigit(currentRow, currentCol, board);
        }

        return solveBoard(currentRow, currentCol + 1, board);
    }

    private boolean tryToFindDigit(int row, int col, ArrayList<ArrayList<Integer>> board) {
        for (int i = 1; i <= 9; i++) {
            if (isValidDigit(i, row, col, board)) {
                board.get(row).set(col, i);
                if (solveBoard(row, col + 1, board)) {
                    return true;
                }
            }
        }

        board.get(row).set(col, 0);
        return false;
    }

    private boolean isValidDigit(int value, int row, int col, ArrayList<ArrayList<Integer>> board) {
        // check valid digit in the row
        for (int i = 0; i < board.get(row).size(); i++) {
            if (i != col && board.get(row).get(i) == value) {
                return false;
            }
        }

        // check valid digit in the column
        for (int i = 0; i < board.get(row).size(); i++) {
            if (i != row && board.get(i).get(col) == value) {
                return false;
            }
        }

        // check the block of the value
        int startRowBlock = (row / 3) * 3;
        int startColBlock = (col / 3) * 3;

        for (int i = startRowBlock; i < 3; i++) {
            for (int b = startColBlock; b < 3; b++) {
                if (i != row && b != col && board.get(i).get(b) == value) {
                    return false;
                }
            }
        }
        return true;
    }
}
