package com.example.TreesAndGraph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//    https://leetcode.com/problems/maximum-average-subtree/
//            Input: [5,6,1]
//            Output: 6.00000
//            Explanation:
//            For the node with value = 5 we have an average of (5 + 6 + 1) / 3 = 4.
//            For the node with value = 6 we have an average of 6 / 1 = 6.
//            For the node with value = 1 we have an average of 1 / 1 = 1.
//            So the answer is 6 which is the maximum.

public class MaximumAverageSubtree_1120 {

    public static TreeNode root;
    public static void main(String[] args) {
        addNode(2);   //[2,null,1]
        double result = maximumAverageSubtree(root);
        System.out.println(result);
    }

    //Post Order traversal
    static double maxAvg = Integer.MIN_VALUE;
    public static double maximumAverageSubtree(TreeNode root) {
       if (root == null) return 0;
       helper(root);
       return maxAvg;
    }

    //sum, count
    public static int[] helper(TreeNode node) {
        if (node == null) return new int[]{0,0};

        int[] left = helper(node.left);
        int[] right = helper(node.right);

        int currSum = left[0] + right[0] +node.val;
        int count = left[1]+right[1]+1;
        double currAvg = (double)currSum/count;
        maxAvg = Math.max(maxAvg, currAvg);
        return new int[] {currSum, count};
    }

    public static void addNode(int value) {
        root = new TreeNode(value);
        //root.left = new TreeNode(6);
        root.right = new TreeNode(1);
//        root.right.right = new TreeNode(7);
//        root.right.left = new TreeNode(15);
    }

    public static class Node {
        TreeNode node;
        int hd;

        public Node(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
