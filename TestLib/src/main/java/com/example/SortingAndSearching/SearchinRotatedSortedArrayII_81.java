package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.List;

public class SearchinRotatedSortedArrayII_81 {
//    Input: nums = [2,5,6,0,0,1,2], target = 0
//    Output: true
//    https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
    // [4,5,6,7,0,1,2],

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
//        int[] nums = {2,5,6,0,0,1,2};
        int[] nums = {1};
//        int[] nums = {2,2,2,3,2,2,2};
        int target = 1;
        System.out.print(search(nums, target));
    }
//    https://github.com/KnowledgeCenterYoutube/LeetCode/blob/master/81_Search_in_Rotated_Sorted_Array_II

    //left = 0 right = len-1
    // midpt, nums[midpt]==target return
    //  nums[target]==nums[left] && nums[target]==nums[right] left++ right--
    //nums[left] <= nums[midpt] (left part is sorted)
    //nums[left] <= target && target < nums[midpt] -> right = midpt-1
    public static boolean search(int[] nums, int target) {
        int l=0, r = nums.length-1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target) return true;
            if( (nums[l] == nums[mid]) && (nums[r] == nums[mid])) {
                l++; r--;
            }  else if(nums[l] <= nums[mid]){   //left half is sorted
                if((nums[l] <= target) && (nums[mid] > target)){
                    r = mid-1;
                }
                else {
                    l = mid + 1;
                }
            } else {
                if((nums[mid] < target) && (nums[r] >= target)) {
                    l = mid + 1;
                }
                else {
                    r = mid-1;
                }
            }
        }
        return false;
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
