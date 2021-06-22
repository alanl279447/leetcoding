package com.example.TreesAndGraph;


import java.nio.charset.CharacterCodingException;
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
//   time complextity 0(n+m)

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
//        addNode(3);
        int[][] edges = {{0,1}, {1,2}, {3,4}};
        int result = countComponentsDfs(5, edges);
        result = countComponentsUnionFind(5, edges);
        System.out.print(result);
    }

    //union find path compression & union by size
    public static int countComponentsUnionFind(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        int components = n;
        for (int[] e : edges) {
            int p1 = find(parent, e[0]);
            int p2 = find(parent, e[1]);
            if (p1 != p2) {
                if (size[p1] < size[p2]) { // Merge small size to large size
                    size[p2] += size[p1];
                    parent[p1] = p2;
                } else {
                    size[p1] += size[p2];
                    parent[p2] = p1;
                }
                components--;
            }
        }
        return components;
    }

    public static int find(int[] roots, int id) {
        while(roots[id] != id) {
            roots[id] = roots[roots[id]];  // optional: path compression
            id = roots[id];
        }
        return id;
    }
    //union find

    //dfs soln
    public static int countComponentsDfs(int nodesCount, int[][] edges) {
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
    //dfs soln










//    public static List<String> countComponentsDfsPrint(List<Character> nodes, char[][] edges) {
//        Map<Character, List<Character>> map = new HashMap<>();
//        List<String> result = new ArrayList<>();
//        for (char[] edge: edges) {
//            map.putIfAbsent(edge[0], new ArrayList<>());
//            map.putIfAbsent(edge[1], new ArrayList<>());
//
//            map.get(edge[0]).add(edge[1]);
//            map.get(edge[1]).add(edge[0]);
//        }
//
//        int count = 0;
//        Set<Character> set = new HashSet<>();
//        for (Character node: nodes) {
//            StringBuilder sb = new StringBuilder();
//            dfsTest(node, map, set, sb);
//            result.add(sb.toString());
//            count++;
//        }
//        return result;
//    }
//
//    public static void dfsTest(Character node, Map<Character, List<Character>> map, Set<Character> set, StringBuilder sb) {
//        if (set.add(node)) {
//            sb.append(node);
//            for (Character nei: map.get(node)) {
//                sb.append("<->");
//                dfsTest(nei, map, set, sb);
//            }
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