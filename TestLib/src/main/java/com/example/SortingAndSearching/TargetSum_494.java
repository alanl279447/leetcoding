package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TargetSum_494 {
//    Input: nums is [1, 1, 1, 1, 1], S is 3.
//    Output: 5
//    Explanation:
//            -1+1+1+1+1 = 3
//            +1-1+1+1+1 = 3
//            +1+1-1+1+1 = 3
//            +1+1+1-1+1 = 3
//            +1+1+1+1-1 = 3
//    There are 5 ways to assign symbols to make the sum of nums be target 3.
//    https://leetcode.com/problems/target-sum/
//    https://leetcode.com/problems/target-sum/discuss/97334/Java-(15-ms)-C%2B%2B-(3-ms)-O(ns)-iterative-DP-solution-using-subset-sum-with-explanation

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        System.out.print(findTargetSumWays(nums, 3));
    }


    //sumP - sumN = target
    //sumP -sumN + (sumP+sumN) = target+sum
    // 2 sumP = target+sum
    //sumP = (target+sum)/2

    //sumP - sumN = target
    //sumP - sumN + sumP + sumN = target + sum
    // sumP = (target+sum)/2
//    Find a subset P of nums such that sum(P) = (target + sum(nums)) / 2

    public static int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(S > sum || (sum + S) % 2 == 1)   return 0;
        return subsetSumDP(nums, (sum + S) / 2);
    }

    private static int subsetSum(int[] nums, int S){
        int[] dp = new int[S + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = S; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[S];
    }

//    https://leetcode.com/problems/target-sum/discuss/97334/Java-(15-ms)-C%2B%2B-(3-ms)-O(ns)-iterative-DP-solution-using-subset-sum-with-explanation
    private static int subsetSumDP(int[] nums, int S){
        int[][]dp = new int[nums.length][S+1];
        for (int i = 0; i < nums.length; i++) dp[i][0] = 1;
        for (int i = 1; i < nums.length; i++)
            //note you need to loop descending, otherwise you'll pickup duplicated partial result along the way
            for (int j = S; j >= nums[i]; j--)
                dp[i][j] = dp[i-1][j] + dp[i-1][j - nums[i]];
        return dp[nums.length-1][S];
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
