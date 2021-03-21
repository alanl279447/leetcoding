package com.example.TreesAndGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SubtreeofAnotherTree_572 {
//               3
//              / \
//             4   5
//          /   \
//          1   2
//
//               4
//              / \
//             1   2
//    Return true, because t has the same structure and node values with a subtree of s.
//    https://leetcode.com/problems/subtree-of-another-tree/
    public static TreeNode root = null;

    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        TreeNode s = addNodeNews(3);
        TreeNode t = addNodeNewt(4);
        System.out.print(isSubtree(s,t));
    }

    //recursive solution
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private static boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.val != t.val) return false;
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    //iterative solution
    public static boolean isSubtreeIterative(TreeNode s, TreeNode t) {
        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.offer(s);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (isSameTree(node, t)) {
                return true;
            }
            if (node.left != null) {
                nodes.offer(node.left);
            }
            if (node.right != null) {
                nodes.offer(node.right);
            }
        }
        return false;
    }

    public static boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        } else {
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode addNodeNews(int value) {
        TreeNode node = new TreeNode(value);
        node.left = new TreeNode(4);
        node.right = new TreeNode(5);
        node.left.right = new TreeNode(2);
        node.left.left = new TreeNode(1);
//        root.right.right = new TreeNode(7);
        return node;
    }

    public static TreeNode addNodeNewt(int value) {
        TreeNode node = new TreeNode(value);
        node.left = new TreeNode(1);
        node.right = new TreeNode(2);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
        return node;
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