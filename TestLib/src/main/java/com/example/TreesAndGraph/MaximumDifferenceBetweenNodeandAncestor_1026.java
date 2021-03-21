package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MaximumDifferenceBetweenNodeandAncestor_1026 {
//    Input: [8,3,10,1,6,null,14,null,null,4,7,13]
//    Output: 7
//    Explanation:
//    We have various ancestor-node differences, some of which are given below :
//            |8 - 3| = 5
//            |3 - 7| = 4
//            |8 - 1| = 7
//            |10 - 13| = 3
//    Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
//    https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode(8);
        int result = maxAncestorDiff(root);
//        for (int res: result) {
            System.out.print(result);
//        }
    }

    static int res = 0;
    public static int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val, root.val);
        return res;
    }

    private static void dfs(TreeNode node, int min, int max) {
        if (node == null) return;
        min = Math.min(node.val, min);
        max = Math.max(node.val, max);
        res = Math.max(res, max - min);
        dfs(node.left, min, max);
        dfs(node.right, min, max);
    }

    public static void addNode(int value) {
        if (root == null)
         root = new TreeNode(value);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);

        root.right = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
    }

    // Definition for a Node.
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}

