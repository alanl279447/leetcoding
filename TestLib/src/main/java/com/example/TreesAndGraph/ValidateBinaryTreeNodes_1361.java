package com.example.TreesAndGraph;

//Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
//        Output: false
//https://leetcode.com/problems/validate-binary-tree-nodes/

import java.util.HashSet;
import java.util.Set;

//Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
//Output: true
//https://leetcode.com/problems/validate-binary-tree-nodes/

//No node should have more than one parent
//There should be exactly one node with zero parents
//There is only one group of connected nodes.

public class ValidateBinaryTreeNodes_1361 {
    public static void main(String[] args) {
        int[] leftChild = {1,-1,3,-1};
        int[] rightChild = {2,3,-1,-1};
        System.out.println(validateBinaryTreeNodes(4, leftChild, rightChild));
    }

     //inDegree for each node (no of incoming edges)
     //inDegree for root = 0 (only one), all other nodes = 1 (not more)
     //one connected component
    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] inDegree = new int[n];    //no of edges going into a node
        for (int i = 0; i < n; i++) {
            int l = leftChild[i], r = rightChild[i];
            if (l != -1) inDegree[l]++;
            if (r != -1) inDegree[r]++;
        }
        // Check 1) single root; 2) other nodes have in-degree = 1
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                if (root != -1) return false;  // two roots
                root = i;
            }
            if (inDegree[i] > 1) {   //more than one parent
                return false;
            }
        }
        if (root == -1) return false;  // no root
        // Check if graph is connected. Example:
        // n = 4, leftChild = [1,0,3,-1], rightChild = [-1,-1,-1,-1]
        boolean[] visited = new boolean[n];
        dfs(root, leftChild, rightChild, visited);
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    private static void dfs(int root, int[] leftChild, int[] rightChild, boolean[] visited) {
        if (root == -1 || visited[root]) return;
        visited[root] = true;
        dfs(leftChild[root], leftChild, rightChild, visited);
        dfs(rightChild[root], leftChild, rightChild, visited);
    }
}