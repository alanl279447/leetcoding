package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class GraphValidTree_261 {

//    Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
//    Output: true
//    https://leetcode.com/problems/graph-valid-tree/

    public static void main(String[] args) {
        int[][] edges = {{0,1}, {0,2}, {0,3}, {1,4}};
        System.out.println(validTree(5, edges));
    }


    //    These are the solutions using the optimizations path compression and union by size.
    public boolean validTreeUnionFindFast(int n, int[][] edges) {
           if (edges.length != n-1) return false;
           int[] roots = new int[n];

           //init parent nodes
           for (int i = 0; i < n; i++) {
               roots[i] = i;
           }
           for (int[] edge: edges) {
               int root1 = find(roots, edge[0]);
               int root2 = find(roots, edge[1]);

               if (root1 == root2) return false;
               roots[root1] = root2;
           }
           return true;
    }

    public int find(int[] roots, int id) {
        while (id != roots[id]) {
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        return roots[id];
    }



    //    For the graph to be a valid tree, it must have exactly n - 1 edges.
//    Any less, and it can't possibly be fully connected. Any more, and it has to contain cycles.
//    Additionally, if the graph is fully connected and contains exactly n - 1 edges,
//    it can't possibly contain a cycle, and therefore must be a tree!
    public static boolean validTreeBFS(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        // Make the adjacency list.
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        queue.offer(0);
        seen.add(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbour : adjacencyList.get(node)) {
                if (seen.contains(neighbour)) continue;
                seen.add(neighbour);
                queue.offer(neighbour);
            }
        }
        return seen.size() == n;
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
