package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.List;

public class LargestBSTSubtree_333 {
//    Input:     1         1
//            / \       / \
//            2   1     1   2
//
//            [1,2,1],   [1,1,2]
//
//    Output: false
//    https://leetcode.com/problems/same-tree/

    public static TreeNode root = null;
    public static TreeNode root2 = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode();
        addNode2();
        System.out.println(isSameTree(root, root2));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
      if (p==null && q == null) return true;
      if (p==null || q == null) return false;

      if (p.val != q.val) return false;
      return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void addNode() {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
//        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
    }

    public static void addNode2() {
        root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
//        root2.right.right = new TreeNode(7);
//        root2.right.left = new TreeNode(15);
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
