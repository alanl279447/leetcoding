package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IsGraphBipartite_785 {

//    Example 1:
//    Input: [[1,3], [0,2], [1,3], [0,2]]
//    Output: true
//    Explanation:
//    The graph looks like this:
//            0----1
//            |    |
//            |    |
//            3----2
//    We can divide the vertices into two groups: {0, 2} and {1, 3}.
//    https://leetcode.com/problems/is-graph-bipartite/
//Time Complexity: O(N + E)O(N+E), where NN is the number of nodes in the graph, and EE is the number of edges.

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[][] nums1 = {{1,3}, {0,2}, {1,3}, {0,2}};
        System.out.print(isBipartite(nums1));
    }

    public static boolean isBipartite(int[][] graph) {
        int length = graph.length;
        int[] colors = new int[length];

        for (int i =0; i <length; i++) {
            if (colors[i] != 0) {
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            colors[i] = 1;

            while(!queue.isEmpty()) {
                int node = queue.poll();
                for (int neigh: graph[node]) {
                    if (colors[neigh] == 0) {
                        colors[neigh] = - colors[node];
                        queue.offer(neigh);
                    } else {
                        if (colors[neigh] != -colors[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
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
