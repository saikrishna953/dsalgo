package com.dsalgo.stacksAndQueues;

import java.util.Stack;

//https://www.geeksforgeeks.org/the-celebrity-problem/
//tc-o(n)
public class Celebrity {
    public static void main(String[] args) {
        int m[][] = {{0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0}};

        int result = findCelebrity(m);
        System.out.println(result);

    }

    private static int findCelebrity(int[][] m) {

        Stack<Integer> s = new Stack<>();
        int c;
        for (int i = 0; i < m.length; i++) {
            s.push(i);
        }
        while (s.size() > 1) {
            int a = s.pop();
            int b = s.pop();
            if (m[a][b] == 1) {
                s.push(b);
            } else {
                s.push(a);
            }
        }

        //only two people in the matrix
        if (s.isEmpty()) {
            return -1;
        }
        c = s.pop();
        for (int i = 0; i < m.length; i++) {
            if ((c != i && m[c][i] == 1) && (m[i][c] != 1)) {
                return -1;
            }
        }
        return c;
    }
}
