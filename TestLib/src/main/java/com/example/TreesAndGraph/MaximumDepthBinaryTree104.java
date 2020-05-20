package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.List;

public class MaximumDepthBinaryTree104 {
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
        System.out.print(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        int res = getMaxDepth(root, 0, result);
        return res;
    }

    //recursive working soln
    public static int getMaxDepth(TreeNode node, int depth, List<Integer> depths) {
        if (node == null) return 0;

        if (depths.size() == depth) {
            depths.add(depth);
        }
        int currMax  = depths.size();
        int leftMax = getMaxDepth(node.left, depth+1, depths);
        int rightMax = getMaxDepth(node.right, depth+1, depths);

        return Math.max(currMax, Math.max(leftMax, rightMax));
    }


    public static void addNode(int value) {
        root = addNodeRecursive(root, value);
        root.left = new TreeNode(9);
//        root.left.left = new TreeNode(5);
//        root.left.right = new TreeNode(3);

        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
    }

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
