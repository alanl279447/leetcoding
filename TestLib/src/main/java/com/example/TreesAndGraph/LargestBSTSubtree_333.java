package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.List;

public class LargestBSTSubtree_333 {
//    Input: [10,5,15,1,8,null,7]
//
//            10
//            / \
//            5  15
//            / \   \
//            1   8   7
//
//    Output: 3
//    Explanation: The Largest BST Subtree in this case is the highlighted one.
//    The return value is the subtree's size, which is 3.
//    https://leetcode.com/problems/largest-bst-subtree/

    // return array for each node:
    //     [0] --> min
    //     [1] --> max
    //     [2] --> largest BST in its subtree(inclusive)

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode();
        System.out.println(largestBSTSubtree(root));
    }

    public static int largestBSTSubtree(TreeNode root) {
        int[] ret = largestBST(root);
        return ret[2];
    }

    private static int[] largestBST(TreeNode node){
        if(node == null){
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        int[] left = largestBST(node.left);
        int[] right = largestBST(node.right);
        if(node.val > left[1] && node.val < right[0]){
            return new int[]{Math.min(node.val, left[0]), Math.max(node.val, right[1]), left[2] + right[2] + 1};
        }else{
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2], right[2])};
        }
    }

    public static void addNode() {
        root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(7);
//        root.right.left = new TreeNode(15);
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
