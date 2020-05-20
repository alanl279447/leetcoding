package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.List;

public class DesignCircularQueue_622 {
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
        int left = findNodeValue(node.left);
        int right = findNodeValue(node.right);
        int pathValue = nodeValue +left + right;

        max_sum = Math.max(max_sum, pathValue);
        return nodeValue + Math.max(left, right);
    }

//    public static int maxPathSum(TreeNode root) {
//        nodeMax(root);
//        return max_value;
//    }
//
//    public static int max_value = Integer.MIN_VALUE;
//    public static int nodeMax(TreeNode node) {
//        int nodeValue = 0;
//        if (node == null) return nodeValue;
//
//        nodeValue = node.val;
//        // max sum on the left and right sub-trees of node
//        int leftmax = Math.max(nodeMax(node.left), 0);
//        int rightmax = Math.max(nodeMax(node.right), 0);
//
//        // the price to start a new path where `node` is a highest node
//        int pathValue = nodeValue + leftmax + rightmax;
//        // update max_sum if it's better to start a new path
//        max_value = Math.max(max_value, pathValue);
//
//        // for recursion :
//        // return the max gain if continue the same path
//        return nodeValue + Math.max(leftmax, rightmax);
//    }


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
