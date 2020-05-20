package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.List;

public class PathSum_112 {
//    Given the below binary tree and sum = 22,
//
//            5
//            / \
//            4   8
//            /   / \
//            11  13  4
//            /  \      \
//            7    2      1
//    https://leetcode.com/problems/path-sum/

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode(5);
        System.out.print(hasPathSum(root, 22));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
       if (root == null) return false;
       return helper(root, sum);
    }

    public static boolean helper(TreeNode node, int sum) {
        if (node == null) {
           return false;
        }
        sum = sum - node.val;
        if (node.right == null && node.left == null && sum ==0) {
            return true;
        }
        return helper(node.left, sum) || helper(node.right, sum);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void addNode(int value) {
        root = addNodeRecursive(root, value);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
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
