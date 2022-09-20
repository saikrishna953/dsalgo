package com.dsalgo.dp;

public class PerimeterOfLargestIsland {

    public static void main(String[] args) {

        int[][] input = {{0, 1, 1, 0, 0, 1},
                {1, 1, 1, 0, 1, 1},
                {0, 1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1}};

    /*int[][] input = {{0,1,1,0,0,1},
                    {1,1,1,0,1,1},
                    {0,1,1,0,0,1}}; */
        PerimeterOfLargestIsland s = new PerimeterOfLargestIsland();
        System.out.println(s.getLargestPerimeter(input));
    }

    private int getLargestPerimeter(int[][] m) {

        int r = m.length;

        int c = m[0].length;
        IslandNode[][] node = new IslandNode[r][c];
        for (int k = 0; k < r; k++) {
            for (int l = 0; l < c; l++) {
                node[k][l] = new IslandNode();
            }
        }
        int maxPerimeterLength = 0;
        int islandPL = 0;
        int cnt = 0;

        for (int i = 0; i < r; i++) {

            for (int j = 0; j < c; j++) {
                if (m[i][j] == 1 && !node[i][j].visited) {
                    DFS(m, i, j, node);
                    cnt++;
                    islandPL = 0;
                    for (int k = 0; k < r; k++) {
                        for (int l = 0; l < c; l++) {
                            if (node[k][l].visited && !node[k][l].visitedForPerimeterCalc) {
                                islandPL += node[k][l].perimeterLength;
                                node[k][l].visitedForPerimeterCalc = true;
                            }
                        }

                    }
                    maxPerimeterLength = Math.max(maxPerimeterLength, islandPL);
                }
            }
        }
        return maxPerimeterLength;
    }

    class IslandNode {
        boolean visited;
        int perimeterLength;
        boolean visitedForPerimeterCalc;
    }

    private void DFS(int[][] m, int i, int j, IslandNode[][] node) {
        node[i][j].visited = true;
        int rowNbr[] = new int[]{-1, 0, 0, 1};
        int colNbr[] = new int[]{0, 1, -1, 0};
        updatePerimeterLengthForTheNode(m, i, j, node);
        for (int k = 0; k < 4; k++) {
            if (isValid(m, i + rowNbr[k], j + colNbr[k], node)) {

                DFS(m, i + rowNbr[k], j + colNbr[k], node);
            }
        }
    }

    private boolean isValid(int[][] m, int i, int j, IslandNode[][] node) {

        boolean isValid = ((i >= 0) && (i < m.length) && (j >= 0) && (j < m[0].length) && (m[i][j] == 1) && !node[i][j].visited);


        return isValid;
    }

    private void updatePerimeterLengthForTheNode(int[][] m, int i, int j, IslandNode[][] node) {


        int rowNbr[] = new int[]{-1, 0, 0, 1};
        int colNbr[] = new int[]{0, 1, -1, 0};
        int p = 0;
        for (int k = 0; k < 4; k++) {
            int currRow = i + rowNbr[k];
            int currCol = j + colNbr[k];
            if ((currRow >= 0) && (currRow < m.length) && (currCol >= 0) && (currCol < m[0].length) && m[currRow][currCol] != 1) {
                p++;
            } else if ((currRow < 0) || (currRow >= m.length)) {
                p++;
            } else if ((currCol < 0) || (currCol >= m[0].length)) {
                p++;
            }

        }
        node[i][j].perimeterLength = p;

    }

}
