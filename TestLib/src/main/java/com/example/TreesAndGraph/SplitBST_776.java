package com.example.TreesAndGraph;

import java.util.LinkedList;
import java.util.List;

public class SplitBST_776 {
//    Input: root = [4,2,6,1,3,5,7], V = 2
//    Output: [[2,1],[4,3,6,null,null,5,7]]
//    Explanation:
//    Note that root, output[0], and output[1] are TreeNode objects, not arrays.
//
//    The given tree [4,2,6,1,3,5,7] is represented by the following diagram:
//
//            4
//            /   \
//            2      6
//            / \    / \
//            1   3  5   7
//
//            while the diagrams for the outputs are:
//
//            4
//            /   \
//            3      6      and    2
//            / \           /
//            5   7         1
//    https://leetcode.com/problems/split-bst/

    public static TreeNode root;
    private static TreeNode ans = null;

    public static void main(String[] args) {
        addNode(4);
        TreeNode[] result = splitBST(root, 2);
        for(TreeNode res: result)
          System.out.println(res.val);
    }

    public static TreeNode[] splitBST(TreeNode root, int V) {
        if(root==null) return new TreeNode[]{null, null};

        TreeNode[] splitted;
        if(root.val<= V) {
            splitted = splitBST(root.right, V);
            root.right = splitted[0];
            splitted[0] = root;
        } else {
            splitted = splitBST(root.left, V);
            root.left = splitted[1];
            splitted[1] = root;
        }

        return splitted;
    }

    public static void addNode(int value) {
        root = new TreeNode(value);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(1);

        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(5);
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
