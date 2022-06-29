package com.dsalgo.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphSearch {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        bfs(graph, 2);

        dfs(graph, 2);
    }

    private static void bfs(Graph graph, int v) {

        boolean[] visited = new boolean[graph.V];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(2);
        visited[v] = true;
        while (!queue.isEmpty()) {
            int s = queue.peek();
            queue.pop();
            System.out.println(s + ", ");
            Iterator<Integer> it = graph.adjArrayList[s].listIterator();
            while (it.hasNext()) {
                int f = it.next();
                if (!visited[f]) {
                    queue.add(f);
                    visited[f] = true;
                }
            }
        }
    }

    private static void dfs(Graph graph, int v) {

        boolean[] visited = new boolean[graph.V];
        DFSUtil(graph, v, visited);

    }

    private static void DFSUtil(Graph graph, int v, boolean[] visited) {
        visited[v] = true;
        System.out.println(v + ", ");
        Iterator<Integer> it = graph.adjArrayList[v].listIterator();
        while (it.hasNext()) {
            int f = it.next();
            if (!visited[f]) {
                DFSUtil(graph, f, visited);
            }
        }
    }


}
