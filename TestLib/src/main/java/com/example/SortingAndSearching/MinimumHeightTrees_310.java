package com.example.SortingAndSearching;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class MinimumHeightTrees_310 {

//    Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
//
//            0
//            |
//            1
//           / \
//          2   3
//
//    Output: [1]
//    https://leetcode.com/problems/minimum-height-trees/

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[][] edges = {{1,0}, {1,2}, {1,3}};
        System.out.print(findMinHeightTrees(4, edges));
    }

    public static List<Integer> findMinHeightTreesTest(int n,int[][] edges) {
        List<Integer> result= new ArrayList<>();

        if(n<=0) return result;
        if(n ==1){
            result.add(0);
            return result;
        }
        List<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
        for (int[] edge: edges) {
         adj[edge[0]].add(edge[1]);
         adj[edge[1]].add(edge[0]);
        }
        int[] indegree = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<n;i++) {
            indegree[i] = adj[i].size();
            if (indegree[i]==1){
                queue.offer(i);
            }
        }
        while(n>2) {
            int size = queue.size();
            n -= size;
            for (int i=0; i<size;i++) {
                int node = queue.poll();
                for(int w: adj[node]) {
                   indegree[w]--;
                   if (indegree[w]==1) {
                       queue.offer(w);
                   }
                }
            }
        }
        result.addAll(queue);
        return result;
    }




    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            if (adj.get(i).size() == 1) leaves.add(i);

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void addNode(int value) {
        root = addNodeRecursive(root, value);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
    }

    public static TreeNode addNodeRecursive(TreeNode node, int value) {
//        TreeNode newNode = null;
        if (node == null) {
            node = new TreeNode(value);
            return node;
        }

        if (value < node.val) {
            node.left = addNodeRecursive(node.left, value);
        } else if (value > node.val){
            node.right = addNodeRecursive(node.right, value);
        } else {
            return node;
        }
        return node;
    }
}
