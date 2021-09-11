package com.dsalgo;

import java.util.Arrays;

public class SetMatrixZeros {

    public static void main(String[] args) {

        int[][] input = {{1,1,1},{1,0,1},{1,1,1}};

        setZeroes1(input);
        System.out.println(Arrays.deepToString(input));
    }

    //Additional Memory Approach
    public static void setZeroes(int[][] matrix) {

        int x = matrix.length;
        int y = matrix[0].length;

        int[] row = new int[x];
        int[] col = new int[y];

        Arrays.fill(row,-1);
        Arrays.fill(col,-1);

        for(int i=0;i<x;i++){

            for(int j=0;j<y;j++){

                if(matrix[i][j] == 0){
                    row[i]=col[j]=0;
                }
            }
        }

        for(int i=0;i<x;i++){

            for(int j=0;j<y;j++){

                if(row[i]== 0 || col[j]==0){
                    matrix[i][j]=0;
                }
            }
        }

    }

    //Optimal approach
    public static void setZeroes1(int[][] matrix) {
        Boolean isCol = false;
        int R = matrix.length;
        int C = matrix[0].length;

        for (int i = 0; i < R; i++) {

            // Since first cell for both first row and first column is the same i.e. matrix[0][0]
            // We can use an additional variable for either the first row/column.
            // For this solution we are using an additional variable for the first column
            // and using matrix[0][0] for the first row.
            if (matrix[i][0] == 0) {
                isCol = true;
            }

            for (int j = 1; j < C; j++) {
                // If an element is zero, we set the first element of the corresponding row and column to 0
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Iterate over the array once again and using the first row and first column, update the elements.
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // See if the first row needs to be set to zero as well
        if (matrix[0][0] == 0) {
            for (int j = 0; j < C; j++) {
                matrix[0][j] = 0;
            }
        }

        // See if the first column needs to be set to zero as well
        if (isCol) {
            for (int i = 0; i < R; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
