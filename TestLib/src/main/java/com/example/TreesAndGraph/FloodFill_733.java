package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FloodFill_733 {
//    Input:
//    image = [[1,1,1],[1,1,0],[1,0,1]]
//    sr = 1, sc = 1, newColor = 2
//    Output: [[2,2,2],[2,2,0],[2,0,1]]
//    Explanation:
//    From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
//    by a path of the same color as the starting pixel are colored with the new color.
//    Note the bottom corner is not colored 2, because it is not 4-directionally connected
//    to the starting pixel.
//    https://leetcode.com/problems/flood-fill/


    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
//        addNode();
        int[][] input = {{1,1,1}, {1,1,0}, {1,0,1}};
//        int[][] result = floodFill(input, 1,1, 2);
//        for (int[] res:result) {
//            System.out.println(result);
//        }
    }

//    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//        for (int i =0;)
//
//
//
//
//    }

//    private static int numDistinctIslands(int[][] input) {
//        Set<String> set = new HashSet<>();  //distinct islands
//
//        for (int i =0; i < input.length;i++) {
//            for (int j=0;j<input[i].length;j++) {
//                if (input[i][j] ==1) {
//                    StringBuilder sb = new StringBuilder();
//                    bfs(i,j, input, sb, 'o');
//                    set.add(sb.toString());
//                }
//            }
//        }
//        return set.size();
//    }
//
//    private static void bfs(int i, int j, int[][] grid, StringBuilder sb, Character direction) {
//        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] ==0) {
//            return;
//        }
//        sb.append(direction);
//        grid[i][j] =0;
//        bfs(i-1, j, grid, sb, 'u');
//        bfs(i+1, j, grid, sb, 'd');
//        bfs(i, j-1, grid, sb, 'l');
//        bfs(i, j+1, grid, sb, 'r');
//        sb.append('b');
//    }

    public static void addNode() {
        root = addNodeRecursive(root, 10);
        root.left = new TreeNode(15);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(17);
        root.right.left = new TreeNode(14);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode addNodeRecursive(TreeNode node, int value) {
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
