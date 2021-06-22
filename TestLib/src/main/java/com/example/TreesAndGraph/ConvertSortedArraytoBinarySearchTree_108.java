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
//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/solution/
public class ConvertSortedArraytoBinarySearchTree_108 {
    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode result = sortedArrayToBST(nums);
        System.out.println(result);
    }

    static int[] numbers;
    public static TreeNode helper(int left, int right) {
        if (left > right) return null;
        // always choose left middle node as a root
        int p = (left + right) / 2;    //0
        // preorder traversal: node -> left -> right
        TreeNode root = new TreeNode(numbers[p]);
        root.left = helper(left, p - 1);
        root.right = helper(p + 1, right);
        return root;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        numbers = nums;
        return helper(0, nums.length - 1);    //0-4
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
