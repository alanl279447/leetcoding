package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TreeDiameter_1245 {

//    Input: edges = [[0,1],[1,2],[2,3],[1,4],[4,5]]
//    Output: 4
//    Explanation:
//    A longest path of the tree is the path 3 - 2 - 1 - 4 - 5.
//    https://leetcode.com/problems/tree-diameter/

    public static TreeNode root = null;
    //public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[][] edges = {{0,1}, {1,2}, {2,3}, {1,4}, {4,5}};
        System.out.print(treeDiameter(edges));
    }

    public static int treeDiameter(int[][] edges) {
        int n = edges.length+1;

        LinkedList<Integer>[] adjacencyList = new LinkedList[n];
        for(int i = 0; i < n; ++i) {
            adjacencyList[i] = new LinkedList<>();
        }

        for (int[] edge : edges) {
            adjacencyList[edge[0]].add(edge[1]);
            adjacencyList[edge[1]].add(edge[0]);
        }

        Node start = bfs(0,n,adjacencyList);
        return bfs(start.value,n,adjacencyList).distance;
    }

    private static Node bfs(int u, int n, LinkedList<Integer>[] adj) {
        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        distance[u] = 0;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            for(int i = 0; i < adj[poll].size(); ++i) {
                int v = adj[poll].get(i);
                if(distance[v] == -1) {
                    queue.add(v);
                    distance[v] = distance[poll] + 1;
                }
            }
        }

        int maxDistance = 0;
        int val = 0;
        for(int i = 0; i < n; ++i) {
            if(distance[i] > maxDistance) {
                maxDistance = distance[i];
                val = i;
            }
        }
        return new Node(val,maxDistance);
    }

    private static class Node {
        int value;
        int distance;

        public Node(int node, int distance) {
            this.value = node;
            this.distance = distance;
        }
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
