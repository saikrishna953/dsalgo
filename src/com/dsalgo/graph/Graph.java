package com.dsalgo.graph;

import java.util.LinkedList;

public class Graph {

    int V;
    LinkedList<Integer> adjArrayList[];

    Graph(int V) {
        this.V = V;

        adjArrayList = new LinkedList[V];

        for (int i = 0; i < V; i++) {
            adjArrayList[i] = new LinkedList<>();
        }

    }

    void addEdge(int v, int val){
        adjArrayList[v].add(val);
    }
}
