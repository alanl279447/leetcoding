package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class NumberofConnectedComponentinanUndirectedGraph_323 {
//    Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
//
//            0          3
//            |          |
//            1 --- 2    4
//
//    Output: 2
//    https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
//        addNode(3);
        int[][] edges = {{0,1}, {1,2}, {3,4}};
        int result = countComponents(5, edges);
        System.out.print(result);
    }


    public static int countComponents(int nodesCount, int[][] edges) {
        if (nodesCount <= 1) return 1;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nodesCount; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] edge: edges) {
           map.get(edge[0]).add(edge[1]);
           map.get(edge[1]).add(edge[0]);
        }

        int count = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < nodesCount; i++) {
            if (visited.add(i)) {
                dfs(i, visited, map);
                count++;
            }
        }
       return count;
    }

    public static void dfs(int currentNode, Set<Integer> visited, Map<Integer, List<Integer>> map) {
        for (Integer neigh: map.get(currentNode)) {
          if (visited.add(neigh)) {
              dfs(neigh, visited, map);
          }
        }
    }

//    public static int countComponents(int n, int[][] edges) {
//        if (n <= 1)
//            return n;
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            map.put(i, new ArrayList<>());
//        }
//        for (int[] edge : edges) {
//            map.get(edge[0]).add(edge[1]);
//            map.get(edge[1]).add(edge[0]);
//        }
//        Set<Integer> visited = new HashSet<>();
//        int count = 0;
//        for (int i = 0; i < n; i++) {
//            if (visited.add(i)) {
//                dfsVisit(i, map, visited);
//                count++;
//            }
//        }
//        return count;
//    }
//
//    private static void dfsVisit(int i, Map<Integer, List<Integer>> map, Set<Integer> visited) {
//        for (int j : map.get(i)) {
//            if (visited.add(j))
//                dfsVisit(j, map, visited);
//        }
//    }

    public static void addNode(int value) {
        if (root == null)
         root = new TreeNode(value);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);

        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.right = new TreeNode(8);
        root.right.left = new TreeNode(0);
    }

    // Definition for a Node.
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}

