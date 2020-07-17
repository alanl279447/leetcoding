package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.List;

public class GraphValidTree_261 {
//    Input:
//
//            1 - 0 - 0 - 0 - 1
//            |   |   |   |   |
//            0 - 0 - 0 - 0 - 0
//            |   |   |   |   |
//            0 - 0 - 1 - 0 - 0
//
//    Output: 6
//
//    Explanation: Given three people living at (0,0), (0,4), and (2,2):
//    The point (0,2) is an ideal meeting point, as the total travel distance
//    of 2+2+2=6 is minimal. So return 6.
//    https://leetcode.com/problems/best-meeting-point/

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[][] grid = {{1,0,0,0,1}, {0,0,0,0,0}, {0,0,1,0,0}};
        System.out.println(minTotalDistance(grid));
    }


    //get the list of x and y co-ordinates (sorted is needed)
    // find the min distance by finding the median

    public static int minTotalDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        List<Integer> I = new ArrayList<Integer>();
        List<Integer> J = new ArrayList<Integer>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    I.add(i);
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i ++) {
                if (grid[i][j] == 1) {
                    J.add(j);
                }
            }
        }
        return minTotalDistance(I) + minTotalDistance(J);
    }

    public static int minTotalDistance(List<Integer> grid) {
        int i = 0, j = grid.size() - 1, sum = 0;
        while (i < j) {
            sum += grid.get(j--) - grid.get(i++);
        }
        return sum;
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
