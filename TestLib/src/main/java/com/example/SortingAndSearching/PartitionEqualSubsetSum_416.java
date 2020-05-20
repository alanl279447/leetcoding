package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.List;

public class PartitionEqualSubsetSum_416 {
//    Input: [1, 5, 11, 5]
//    Output: true
//    Explanation: The array can be partitioned as [1, 5, 5] and [11].
//
//    https://leetcode.com/problems/partition-equal-subset-sum/

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.print(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n: nums){
            sum += n;
        }
        if(sum%2 != 0) return false;
        for(int i:nums){                //case 1,1,1,100; where you have a big number which can not be splitted.
            if(i > sum/2) return false;
        }
        return helper(nums, nums.length - 1, 0, sum/2);
    }

    private static boolean helper(int[] nums, int j, int sum, int target){
        if(j < 0 || sum > target) return false;

        if(sum == target) return true;

        return helper(nums, j - 1, sum + nums[j], target) || helper(nums, j - 1, sum, target);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void addNode(int value) {
        root = addNodeRecursive(root, value);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
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
