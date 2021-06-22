package com.example.TreesAndGraph;
import java.util.ArrayDeque;
import java.util.Deque;

import javafx.util.Pair;
//Input: [4,9,0,5,1]
//        4
//        / \
//        9   0
//        / \
//        5   1
//        Output: 1026
//        Explanation:
//        The root-to-leaf path 4->9->5 represents the number 495.
//        The root-to-leaf path 4->9->1 represents the number 491.
//        The root-to-leaf path 4->0 represents the number 40.
//        Therefore, sum = 495 + 491 + 40 = 1026.
//        https://leetcode.com/problems/sum-root-to-leaf-numbers/

public class SumRoottoLeafNumbers_129 {
    public static TreeNode root;
    private static TreeNode ans = null;

    public static void main(String[] args) {
        addNode(4);
        System.out.println(sumNumbers(root));
    }

    static int pathSum = 0;
    public static int sumNumbers(TreeNode root) {
       if (root == null) return 0;
       helper(root, 0);
       return pathSum;
    }

    public static void helper(TreeNode node, int sum) {
        if (node == null) return;
        sum = sum * 10 + node.val;
        if (node.left==null && node.right == null) {
            pathSum += sum;
        }
        helper(node.right, sum);
        helper(node.left, sum);
    }

    public int sumNumbersIterative(TreeNode root) {
        if (root == null) return 0;
        int rootToLeafSum = 0;
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque();
        stack.offer(new Pair(root, 0));
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> p = stack.poll();
            int value = p.getValue();
            TreeNode curr = p.getKey();
            value += value*10+curr.val;
            if (curr.left==null && curr.right == null) {
                rootToLeafSum += value;
            }
            if (curr.left != null) {
                stack.offer(new Pair<>(curr.left, value));
            }
            if (curr.right != null) {
                stack.offer(new Pair<>(curr.right, value));
            }
        }
        return rootToLeafSum;
    }

    public static void addNode(int value) {
        root = new TreeNode(value);
        root.left = new TreeNode(9);
        root.left.right = new TreeNode(1);
        root.left.left = new TreeNode(5);
        //root.left.right.right = new TreeNode(6);
        root.right = new TreeNode(0);
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
