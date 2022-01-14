package com.dsalgo;

//https://leetcode.com/problems/sudoku-solver/
public class SudokuSolver {

    public static void main(String[] args) {

        char[][] board = {
                {'8', '3', '.', '5', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '8', '7', '.', '3', '.', '2'},
                {'2', '7', '.', '3', '.', '.', '.', '8', '1'},
                {'.', '.', '.', '.', '3', '4', '9', '.', '.'},
                {'7', '9', '3', '.', '5', '.', '6', '1', '4'},
                {'.', '.', '8', '7', '9', '.', '.', '.', '.'},
                {'9', '2', '.', '.', '.', '3', '.', '5', '7'},
                {'5', '.', '6', '.', '8', '7', '.', '.', '.'},
                {'3', '.', '.', '.', '.', '5', '.', '.', '.'}};
        solveSudoku(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }


    }

    private static void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        solve(board);
    }

    private static boolean solve(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {//trial. Try 1 through 9
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c; //Put c for this cell

                            if (solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c && board[row][i] != '.') {
                return false;
            }
            if (board[i][col] == c && board[i][col] != '.') {
                return false;
            }
            if (board[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] == c) {
                return false;
            }
        }
        return true;
    }


}
