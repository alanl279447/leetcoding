package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class KthSmallestElementBST_230 {
//    Input:
//            2
//            / \
//            2   5
//            / \
//            5   7
//
//    Output: 5
//    Explanation: The smallest value is 2, the second smallest value is 5.
//    https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode();
        int result = findSecondMinimumValue(root);
        System.out.println(result);
    }

    public static int findSecondMinimumValue(TreeNode root) {
        if(root==null || root.right==null || root.left==null) return -1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        Integer secondMin = null;
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr.right!=null) q.offer(curr.right);
            if(curr.left!=null) q.offer(curr.left);
            if(curr.val!=root.val) {
                if(secondMin==null) secondMin = curr.val;
                else secondMin = Math.min(secondMin, curr.val);
            }
        }
        return secondMin==null? -1 : secondMin;
    }

    public static void addNode() {
        root = addNodeRecursive(root, 2);
        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(7);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(5);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode addNodeRecursive(TreeNode node, int value) {
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
