package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.List;

public class PartitiontoKEqualSumSubsets_698 {
//    Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//    Output: True
//    Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
//    https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
//   Input : arr = [2, 1, 4, 5, 6], K = 3
//   time complexity: O(k*2^n)

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
//        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int[] nums = {2,1,4,5,6};
        System.out.println(canPartitionKSubsets(nums, 3));
    }

    //(2,4), (1,5), (6)
//    public static boolean canPartitionKSubsetsPrac(int[] nums, int k) {
//        int sum = 0;
//        for (int num: nums) {
//            sum +=num;
//        }
//        if (k<=0 || sum/k != 0) {
//            return false;
//        }
//        int[] visited = new int[nums.length];
//        return canPartitionPrac(nums, visited, k,0, 0, sum/k);
//    }
//
//    private static boolean canPartitionPrac(int[] nums, int[] visited, int k, int startIndex, int curr_sum, int target) {
//
//    }

     // (6), (5,1), (2,4)
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num:nums) {
            sum += num;
        }
        if(k <= 0 || sum%k != 0) {
            return false;
        }
        int[] visited = new int[nums.length];
        return canPartition(nums, visited, 0, k, 0,sum/k);
    }

    public static boolean canPartition(int[] nums, int[] visited, int start_index, int k, int cur_sum, int target){
        if(k==1){
            return true;
        }
        if (cur_sum >target) return false;
        if(cur_sum == target){
            return canPartition(nums, visited, 0, k-1, 0, target);
        }
        for(int i = start_index; i<nums.length; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                if(canPartition(nums, visited, i+1, k, cur_sum + nums[i], target)) {
                    return true;
                }
                visited[i] = 0;
            }
        }
        return false;
    }//{2,1,4,5,6};

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
