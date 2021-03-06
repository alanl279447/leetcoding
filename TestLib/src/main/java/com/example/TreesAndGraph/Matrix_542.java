package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.List;

public class Matrix_542 {

//    Input:
//            [[0,0,0],
//            [0,1,0],
//            [0,0,0]]
//
//    Output:
//            [[0,0,0],
//            [0,1,0],
//            [0,0,0]]
//    https://leetcode.com/problems/01-matrix/

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        char[][] input = { {'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.print(numIslands(input));
    }

    public static int numIslands(char[][] grid) {
        int numberOfIslands = 0;
        if (grid == null || grid.length == 0) return 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    numberOfIslands += bfs(grid, i, j);
                }
            }
        }
        return numberOfIslands;
    }

    public static int bfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0')
            return 0;
        grid[i][j] = '0';
        bfs(grid, i +1, j);
        bfs(grid, i-1, j);
        bfs(grid, i, j-1);
        bfs(grid, i, j+1);
        return 1;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
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
