package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.List;

//       Given the sorted array: [-10,-3,0,5,9],
//        One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
//        0
//        / \
//        -3   9
//        /   /
//        -10  5
//        https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class ConvertSortedArraytoBinarySearchTree_108 {
    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode result = sortedArrayToBST(nums);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
           if (nums == null) return null;
           return helper(nums, 0, nums.length-1);
    }

    public static TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right-left)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid-1);
        node.right = helper(nums, mid+1, right);
        return node;
    }

    public static void addNode() {
        root = addNodeRecursive(root, 1);
//        root.left = new TreeNode(15);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(7);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
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
