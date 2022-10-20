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

        foo(null);
        Car a = new Car("red");
        Car b = new Car("yellow");
        swap(a,b);
        System.out.println(a.color);
        System.out.println(b.color);

    }

    private static void swap(Car a, Car b) {
        Car tmp = a;
        a=b;
        b=tmp;
    }

    static class Car{
        String color;
        Car(String c){
            this.color = c;
        }
    }

    private static void foo(Object o) {
        System.out.println("print object");
    }

    private static void foo(String o) {
        System.out.println("print string");
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
