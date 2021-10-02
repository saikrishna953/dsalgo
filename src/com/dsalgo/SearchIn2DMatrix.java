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
        if (!leetCodeSearchIn2DMatrix(matrix, number)){
            System.out.println("leet code Number not found");
        }

    }

    private static boolean leetCodeSearchIn2DMatrix(int[][] matrix, int number) {

        if (matrix.length == 0) return false;
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0, high = (n * m - 1);
        while (low <= high) {
            int mid = (low + (high - low)/ 2);
            int x = matrix[mid / m][mid % m];
            if (x == number) {
                System.out.println("leet code Number found");
                return true;
            } else if (number > x) {
                low = mid + 1;
            } else {
                high = mid - 1;
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
