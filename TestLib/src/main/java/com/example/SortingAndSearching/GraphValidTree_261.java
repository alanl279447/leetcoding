package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.List;

public class GraphValidTree_261 {

//    Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
//    Output: true
//    https://leetcode.com/problems/graph-valid-tree/

    public static void main(String[] args) {
        int[][] edges = {{0,1}, {0,2}, {0,3}, {1,4}};
        System.out.println(validTree(5, edges));
    }

    public static boolean validTree(int n, int[][] edges) {
       List<List<Integer>> adjacencyList = new ArrayList<>();
       for (int i=0;i<n;i++) {
           adjacencyList.add(i, new ArrayList<>());
       }

       for (int i=0; i < edges.length; i++) {
           int[] edge = edges[i];
           adjacencyList.get(edge[0]).add(edge[1]);
           adjacencyList.get(edge[1]).add(edge[0]);
       }

       boolean[] visited = new boolean[n];
       if (hasCycles(adjacencyList, 0, visited, -1)) {
           return false;
       }
       for (int i=0; i<n;i++) {
           if (!visited[i]) {
               return false;
           }
       }
       return true;
    }

    public static boolean hasCycles(List<List<Integer>> adj, int u, boolean[] visited, int parent) {
        visited[u]=true;
        for (int i=0; i< adj.get(u).size(); i++) {
            int v = adj.get(u).get(i);
            if ((visited[v] && parent != v) || (!visited[v] && hasCycles(adj, v, visited,u))) {
                return true;
            }
        }
        return false;
    }

}
