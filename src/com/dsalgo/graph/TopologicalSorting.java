package com.dsalgo.graph;

import java.util.Stack;

public class TopologicalSorting {

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        topologicalSorting(g);
    }

    private static void topologicalSorting(Graph g) {
        boolean[] visited = new boolean[g.V];

        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < g.V; i++) {
            if (!visited[i]) {
                topologicalSortingUtil(g, visited, i, s);
            }
        }
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    private static void topologicalSortingUtil(Graph g, boolean[] visited, int i, Stack<Integer> s) {

        visited[i] = true;
        for (int x : g.adjArrayList[i]
        ) {
            if (!visited[x]) {
                topologicalSortingUtil(g, visited, x, s);
            }
        }
        s.push(i);
    }
}
