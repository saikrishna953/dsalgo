package com.dsalgo;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/n-queens/
public class NQueens {

    public static void main(String[] args) {

        //List<List<String>> result = solveNQueensBruteForce(4);
        List<List<String>> result = solveNQueensEfficient(4);
        result.forEach(l -> {
            System.out.println();
            l.forEach(s -> System.out.print(s));
        });
    }

    private static List<List<String>> solveNQueensEfficient(int n) {

        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        int[] leftRow = new int[n];
        int[] lowerDiagonal = new int[2 * n - 1];
        int[] upperDiagonal = new int[2 * n - 1];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        funcEfficient(0, board, leftRow, lowerDiagonal, upperDiagonal, ans);
        return ans;
    }

    private static void funcEfficient(int col, char[][] board, int[] leftRow,
                                      int[] lowerDiagonal, int[] upperDiagonal,
                                      List<List<String>> ans) {
        if (col == board.length) {
            ans.add(construct(board));
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0
                    && upperDiagonal[board.length - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 + col - row] = 1;
                funcEfficient(col + 1, board, leftRow, lowerDiagonal, upperDiagonal, ans);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }

    private static List<List<String>> solveNQueensBruteForce(int n) {

        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        funcBruteForce(0, board, ans);
        return ans;
    }

    private static void funcBruteForce(int col, char[][] board, List<List<String>> ans) {

        if (col == board.length) {
            ans.add(construct(board));
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (validate(board, row, col)) {
                board[row][col] = 'Q';
                funcBruteForce(col + 1, board, ans);
                board[row][col] = '.';
            }
        }

    }

    private static boolean validate(char[][] board, int row, int col) {

        int dupRow = row;
        int dupCol = col;

        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
        }
        row = dupRow;
        col = dupCol;

        while (col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col--;
        }
        row = dupRow;
        col = dupCol;
        while (row < board.length && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row++;
            col--;
        }
        return true;

    }

    private static List<String> construct(char[][] board) {

        List<String> r = new ArrayList<>();
        for (char[] chars : board) {
            r.add(new String(chars));
        }
        return r;
    }
}
