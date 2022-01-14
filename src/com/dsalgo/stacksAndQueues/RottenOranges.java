package com.dsalgo.stacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static void main(String[] args) {
        int[][] arr = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int minNumberOfDays = solution(arr);
        System.out.println(minNumberOfDays);
    }

    private static int solution(int[][] arr) {

        if (arr == null || arr.length == 0) return 0;
        int rows = arr.length;
        int cols = arr[0].length;
        Queue<int[]> q = new LinkedList();
        int count_fresh = 0;
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (arr[i][j] != 0) {
                    count_fresh++;
                }
            }

        }
        if (count_fresh == 0) {
            return 0;
        }
        int queueCnt = 0, minNoOfDays = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!q.isEmpty()) {

            //queueCnt += q.size();
            for (int i = 0; i < q.size(); i++) {
                int[] point = q.poll();
                for (int j = 0; j < 4; j++) {

                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];

                    if (x < 0 || y < 0 || x >= rows || y >= cols || arr[x][y] == 0 || arr[x][y] == 2) {
                        continue;
                    }
                    arr[x][y] = 2;
                    queueCnt++;
                    q.offer(new int[]{x, y});

                }
            }
            if (q.size() != 0) {
                minNoOfDays++;
            }
        }
        return count_fresh == queueCnt ? minNoOfDays : -1;

    }
}
