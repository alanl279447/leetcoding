package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeMaximumPathSum {
//    Input: [-10,9,20,null,null,15,7]
//
//            -10
//            / \
//           9  20
//             /  \
//            15   7
//
//    Output: 42

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();

    public static void main(String[] args) {
        addNode(-10);
        System.out.print(maxPathSum(root));
    }


    static int max_sum = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        findNodeValue(root);
        return max_sum;
    }

    public static int findNodeValue(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int nodeValue = node.val;
        int left = Math.max(findNodeValue(node.left), 0);  //imp to add math.max to avoid unnecessary calculation.
        int right = Math.max(findNodeValue(node.right), 0);
        int pathValue = nodeValue +left + right;

        max_sum = Math.max(max_sum, pathValue);
        return nodeValue + Math.max(left, right);
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
