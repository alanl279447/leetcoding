package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumLevelSumBinaryTree_1161 {
//    Input: [1,7,0,7,-8,null,null]
//    Output: 2
//    Explanation:
//    Level 1 sum = 1.
//    Level 2 sum = 7 + 0 = 7.
//    Level 3 sum = 7 + -8 = -1.
//    So we return the level with the maximum sum which is level 2.
//    https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/

    public static TreeNode root;
    private static TreeNode ans = null;

    public static void main(String[] args) {
        addNode(1);
        int result = maxLevelSum(root);
        System.out.println(result);
    }

    public static int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxSum = root.val, level =0, result=0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            int tempMax= 0;
            for (int i=0; i < size; i++) {
                TreeNode curr = queue.poll();
                tempMax +=curr.val;
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            result++;
            if (tempMax > maxSum) {
                maxSum = tempMax;
                level = result;
            }
        }
       return level;
    }

    public static void addNode(int value) {
        root = new TreeNode(value);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
//        root.left.right.right = new TreeNode(6);
//        root.left.right.right.left = new TreeNode(2);

        root.right = new TreeNode(0);
//        root.right.left = new TreeNode(6);
    }

    public static class Node {
        TreeNode node;
        int hd; //horiozntal distance

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
