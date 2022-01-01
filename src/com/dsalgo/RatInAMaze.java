package com.dsalgo;

import java.util.ArrayList;
import java.util.List;

//https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
public class RatInAMaze {

    public static void main(String[] args) {
        int N = 4;
        int[][] m = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};

        List<String> result = helpRat(m, N);
        result.forEach(System.out::println);
    }

    private static List<String> helpRat(int[][] m, int n) {
        int[][] visited = new int[n][n];

        List<String> ans = new ArrayList<>();
        if (m[0][0] == 1) {
            solve(0, 0, visited, m, n, "", ans);
        }
        return ans;
    }

    private static void solve(int row, int col, int[][] visited, int[][] m, int n, String move, List<String> ans) {

        if (row == n - 1 && col == n - 1) {
            ans.add(move);
            return;
        }

        //downward
        if (row + 1 < n && visited[row + 1][col] == 0 && m[row + 1][col] == 1) {
            visited[row + 1][col] = 1;
            solve(row + 1, col, visited, m, n, move + "D", ans);
            visited[row + 1][col] = 0;
        }

        //left
        if ((col - 1) >= 0 && visited[row][col - 1] == 0 && m[row][col - 1] == 1) {
            visited[row][col - 1] = 1;
            solve(row, col - 1, visited, m, n, move + "L", ans);
            visited[row][col - 1] = 0;
        }

        //right
        if ((col + 1) < n && visited[row][col + 1] == 0 && m[row][col + 1] == 1) {
            visited[row][col + 1] = 1;
            solve(row, col + 1, visited, m, n, move + "R", ans);
            visited[row][col + 1] = 0;
        }

        //up
        if (row - 1 >= 0 && visited[row - 1][col] == 0 && m[row - 1][col] == 1) {
            visited[row - 1][col] = 1;
            solve(row - 1, col, visited, m, n, move + "U", ans);
            visited[row - 1][col] = 0;
        }


    }
}
