package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MiddleoftheLinkedList_876 {

//    Input: [[0,0,0],[1,1,0],[1,1,0]]
//    Output: 4
//    https://leetcode.com/problems/shortest-path-in-binary-matrix/

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[][] grid = {{1,0,0}, {1,1,0}, {1,1,0}};
        System.out.print(shortestPathBinaryMatrix(grid));
    }

    static int[][] dir = {{0,1}, {-1,0}, {0,-1}, {1,0}, {1,1}, {1,-1}, {-1, 1}, {-1,-1}};
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0]==1 || grid[m-1][n-1]==1) {
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0,0});
        boolean[][] visited = new boolean[m][n];

        int ans=0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                if (node[0] == m - 1 && node[1] == n - 1) {
                    return ans + 1;
                }
                for (int j=0; j < dir.length; j++) {
                   int newX = node[0]+dir[j][0];
                   int newY = node[1]+dir[j][1];

                   if (newX>=0 && newX<m &&newY>=0 && newY<n && grid[newX][newY]==0
                           && visited[newX][newY]==false) {
                       queue.offer(new int[] {newX, newY});
                       visited[newX][newY]=true;
                   }
                }
            }
            ans++;
        }
        return -1;
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
