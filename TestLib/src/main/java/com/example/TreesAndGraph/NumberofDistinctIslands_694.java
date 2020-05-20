package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberofDistinctIslands_694 {
//        11011
//        10000
//        00001
//        11011
//    Given the above grid map, return 3.
//    https://leetcode.com/problems/number-of-distinct-islands/


    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
//        addNode();
        int[][] input = {{1,1,0,1,1}, {1,0,0,0,0}, {0,0,0,0,1}, {1,1,0,1,1}};
        int result = numDistinctIslands(input);
            System.out.println(result);
    }

    private static int numDistinctIslands(int[][] input) {
        Set<String> set = new HashSet<>();  //distinct islands
        for (int i =0; i < input.length;i++) {
            for (int j=0;j<input[i].length;j++) {
                if (input[i][j] ==1) {
                    StringBuilder sb = new StringBuilder();
                    bfs(i,j, input, sb, 'o');
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    private static void bfs(int i, int j, int[][] grid, StringBuilder sb, Character direction) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] ==0) {
            return;
        }
        sb.append(direction);
        grid[i][j] =0;
        bfs(i-1, j, grid, sb, 'u');
        bfs(i+1, j, grid, sb, 'd');
        bfs(i, j-1, grid, sb, 'l');
        bfs(i, j+1, grid, sb, 'r');
        sb.append('b');
    }


//    public static int numDistinctIslands(int[][] grid) {
//        Set<String> set = new HashSet<>();
//        for(int i = 0; i < grid.length; i++) {
//            for(int j = 0; j < grid[i].length; j++) {
//                if(grid[i][j] != 0) {
//                    StringBuilder sb = new StringBuilder();
//                    dfs(grid, i, j, sb, "o"); // origin
//                    grid[i][j] = 0;
//                    set.add(sb.toString());
//                }
//            }
//        }
//        return set.size();
//    }
//    private static void dfs(int[][] grid, int i, int j, StringBuilder sb, String dir) {
//        if(i < 0 || i == grid.length || j < 0 || j == grid[i].length
//                || grid[i][j] == 0) return;
//        sb.append(dir);
//        grid[i][j] = 0;
//        dfs(grid, i-1, j, sb, "u");
//        dfs(grid, i+1, j, sb, "d");
//        dfs(grid, i, j-1, sb, "l");
//        dfs(grid, i, j+1, sb, "r");
//        sb.append("b"); // back
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
