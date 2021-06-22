package com.example.TreesAndGraph;

public class CherryPickup_741 {
//    https://leetcode.com/problems/cherry-pickup/
//    Input: grid = [[0,1,-1],[1,0,-1],[1,1,1]]
//    Output: 5
//    Explanation: The player started at (0, 0) and went down, down, right right to reach (2, 2).
//            4 cherries were picked up during this single trip, and the matrix becomes [[0,1,-1],[0,0,-1],[0,0,0]].
//    Then, the player went left, up, up, left to return home, picking up one more cherry.
//    The total number of cherries picked up is 5, and this is the maximum possible.

    public static TreeNode root = null;
    public static void main(String[] args) {
        int[][] grid = {{0,1,-1}, {1,0,-1}, {1,1,1}};
//        int result = cherryPickup(grid);
//        System.out.print(result);
    }

//    public static int cherryPickup(int[][] grid) {
//
//    }


    public static void addNode(int value) {
//        root = addNodeRecursive(root, value);
        if (root == null) {
            root = new TreeNode(value);
        }
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }
}
