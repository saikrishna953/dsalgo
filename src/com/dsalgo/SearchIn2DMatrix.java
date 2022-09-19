package com.dsalgo;

public class SearchIn2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int number = 23;

        //gfg approach if all rows and columns are sorted
        if (!gfgSearchIn2DMatrix(matrix, number)) {
            System.out.println("gfg Number not found");
        }

        //leet code approach. Only if first element of each row is greater than last element of previous row
        if (!leetCodeSearchIn2DMatrix(matrix, number)) {
            System.out.println("leet code Number not found");
        }

    }

    private static boolean leetCodeSearchIn2DMatrix(int[][] matrix, int target) {

        if (matrix.length == 0) return false;
        int colLength = matrix[0].length - 1; // each row length
        for (int i = 0; i < matrix.length; i++) { // iterate over every row
            if (target > matrix[i][colLength])
                continue; // if target is greater than the highest number in that row then skip that row

            int start = 0, end = colLength;
            while (start <= end) { // using binary search algorithm to search through the row for the target
                int mid = (start + end) / 2;
                System.out.println(mid);
                if (matrix[i][mid] == target) return true;

                if (matrix[i][mid] > target) end = mid - 1;
                else if (matrix[i][mid] < target) start = mid + 1;
            }
        }
        return false;
    }

    private static boolean gfgSearchIn2DMatrix(int[][] matrix, int number) {

        int n = matrix.length;
        if (n == 0) return false;
        int i = 0, j = n - 1;

        while (i < n && j >= 0) {
            if (matrix[i][j] == number) {
                System.out.println("gfg Number found");
                return true;
            } else if (matrix[i][j] > number) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }
}
