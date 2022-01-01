package com.dsalgo;

import java.util.ArrayList;
import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1#
public class Mcoloring {

    public static void main(String[] args) {
        //coloring possible vertex
        //int V = 4;

        //coloring not possible
        int V = 3;

        ArrayList<ArrayList<Integer>> adj
                = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        //coloring possible inputs
        /*addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 0);
        addEdge(adj, 0, 2);*/

        //coloring not possible inputs
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 0, 2);

        printGraph(adj);
        //coloring possible
        //int noOfColors = 3;

        //coloring not possible
        int noOfColors = 2;

        boolean result = graphColoring(adj, noOfColors);

        if (result) {
            System.out.println("Coloring is possible");
        } else {
            System.out.println("Coloring is not possible");
        }
    }

    private static boolean graphColoring(ArrayList<ArrayList<Integer>> adj, int noOfColors) {

        int n = adj.size();
        int[] color = new int[n];
        Arrays.fill(color, -1);
        return solve(0, adj, color, n, noOfColors);
    }

    private static boolean solve(int node, ArrayList<ArrayList<Integer>> adj, int[] color,
                                 int n, int noOfColors) {
        if (node == n) {
            return true;
        }

        for (int i = 0; i < noOfColors; i++) {
            if (isSafe(node, color, adj, i)) {
                color[node] = i;
                if (solve(node + 1, adj, color, n, noOfColors)) {
                    return true;
                }
                color[node] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int node, int[] color, ArrayList<ArrayList<Integer>> adj, int col) {
        for (int it : adj.get(node)) {
            if (color[it] == col) {
                return false;
            }
        }
        return true;
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj,
                        int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // A utility function to print the adjacency list
    // representation of graph
    static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex" + i);
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" - " + adj.get(i).get(j));
            }
            System.out.println();
        }
    }
}
