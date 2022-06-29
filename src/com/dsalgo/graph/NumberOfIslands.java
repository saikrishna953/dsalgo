package com.dsalgo.graph;

//Using DFs
public class NumberOfIslands {
    public static void main(String[] args) {
        int M[][] = new int[][]{{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};

        System.out.println(countIslands(M));
    }

    private static int countIslands(int[][] m) {

        int rows = m.length;
        int cols = m[0].length;
        int count = 0;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                if (m[i][j] == 1 && !visited[i][j]) {

                    DFS(m, i, j, visited);
                    count++;
                }
            }

        }
        return count;
    }

    private static void DFS(int[][] m, int i, int j, boolean[][] visited) {

        visited[i][j] = true;
        int rowNbr[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int colNbr[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        for (int k = 0; k < 8; k++) {
            if (isSafe(m, i + rowNbr[k], j + colNbr[k], visited)) {
                DFS(m, i + rowNbr[k], j + colNbr[k], visited);
            }
        }
    }

    static boolean isSafe(int M[][], int row, int col,
                          boolean visited[][]) {
        // row number is in range, column number is in range
        // and value is 1 and not yet visited
        return (row >= 0) && (row < M.length) && (col >= 0) && (col < M[0].length) && (M[row][col] == 1 && !visited[row][col]);
    }
}
