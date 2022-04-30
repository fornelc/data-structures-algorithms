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
            currentCol = 0;
            currentRow++;

            if (currentRow == board.size()) {
                return true;
            }
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

        if (board.get(row).contains(value)) {
            return false;
        }

        // check valid digit in the column
        for (int rowIdx = 0; rowIdx < board.get(row).size(); rowIdx++) {
            if (board.get(rowIdx).get(col) == value) {
                return false;
            }
        }

        // check the block of the value
        int startRowBlock = (row / 3) * 3;
        int startColBlock = (col / 3) * 3;

        for (int rowIdx = 0; rowIdx < 3; rowIdx++) {
            for (int colIdx = 0; colIdx < 3; colIdx++) {
                int rowToCheck = startRowBlock + rowIdx;
                int colToCheck = startColBlock + colIdx;
                if (board.get(rowToCheck).get(colToCheck) == value) {
                    return false;
                }
            }
        }
        return true;
    }
}
