package com.example.TreesAndGraph;

import java.util.LinkedList;
import java.util.List;

public class MergeTwoBinaryTrees_617 {

//    Input:
//    Tree 1                     Tree 2
//            1                         2
//            / \                       / \
//            3   2                     1   3
//            /                           \   \
//            5                             4   7
//    Output:
//    Merged tree:
//            3
//            / \
//            4   5
//            / \   \
//            5   4   7
//    https://leetcode.com/problems/merge-two-binary-trees/

    public static TreeNode root;
    private static TreeNode ans = null;

    public static void main(String[] args) {
        addNode(1);
        TreeNode result = mergeTrees(root, root);
        System.out.println(result.val);
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
         if (t1==null && t2 == null) return null;
         if (t1 == null) return t2;
         if (t2 == null) return t1;

         TreeNode result = new TreeNode(t1.val+t2.val);
         result.left = mergeTrees(t1.left, t2.left);
         result.right = mergeTrees(t1.right, t2.right);
         return result;
    }

    public static void addNode(int value) {
        root = new TreeNode(value);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
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
