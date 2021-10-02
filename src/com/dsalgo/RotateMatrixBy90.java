package com.dsalgo;

public class RotateMatrixBy90 {

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};

        bruteForceRotate(matrix);
        System.out.println("Brute force print:");
        printMatrix(matrix);

        System.out.println("Optimal print:");
        optimalRotate(matrix);
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void optimalRotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }
    public static void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }

    public static void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    private static void bruteForceRotate(int[][] matrix) {

        int n = matrix.length;
        for (int i = 0; i < (n+1)/2; i++) {

            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n-1-j][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-1-j];
                matrix[n-i-1][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = matrix[i][j];
                matrix[i][j] = temp;

            }

        }
    }
}
