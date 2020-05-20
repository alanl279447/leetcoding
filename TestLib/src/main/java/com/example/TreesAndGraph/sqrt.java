package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.List;

public class sqrt {
//                    3
//                 /    \
//                9      20
//               / \     / \
//            null null   15 7
//
//    return its depth = 3.
//    https://leetcode.com/problems/maximum-depth-of-binary-tree/

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode(3);
        System.out.print(mySqrt(8));
    }

    public static int mySqrt(int x) {
        if (x < 2) return x;

        long num;
        int pivot, left = 2, right = x / 2;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            num = (long)pivot * pivot;
            if (num > x) right = pivot - 1;
            else if (num < x) left = pivot + 1;
            else return pivot;
        }

        return right;
    }

    // public static int currMax = 0;
//    public static int getMaxDepth(TreeNode node, int depth, List<Integer> depths) {
//        if (node == null) return 0;
//
//        if (depths.size() == depth) {
//            depths.add(depth);
//        }
//        int currMax  = depths.size();
//        int leftMax = getMaxDepth(node.left, depth+1, depths);
//        int rightMax = getMaxDepth(node.right, depth+1, depths);
//
//        return Math.max(currMax, Math.max(leftMax, rightMax));
//    }

    public static void addNode(int value) {
        root = addNodeRecursive(root, value);
        root.left = new TreeNode(9);
//        root.left.left = new TreeNode(5);
//        root.left.right = new TreeNode(3);

        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
    }

//    public static int widthOfBinaryTree(TreeNode root) {
//        return dfs(root, 0, 1, new ArrayList<>());
//    }
//
//    private static int dfs(TreeNode node, int depth, int postion, List<Integer> starts) {
//        if (node == null) return 0;
//        if (starts.size() == depth) starts.add(postion);
//
//        int cur = postion - starts.get(depth) + 1;
//        int leftResult = dfs(node.left, depth + 1, postion * 2 + 1, starts);
//        int rightResult = dfs(node.right, depth + 1, postion * 2 + 2, starts);
//        return Math.max(cur, Math.max(leftResult, rightResult));
//    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
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
