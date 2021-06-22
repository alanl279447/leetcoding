package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.List;

public class SearchRotatedSortedArrays {

//    Input: nums = [4,5,6,7,0,1,2], target = 0
//    Output: 4
//
//    Input: nums = [4,5,6,7,0,1,2], target = 3
//    Output: -1
//    https://leetcode.com/problems/search-in-rotated-sorted-array/
//    https://github.com/KnowledgeCenterYoutube/LeetCode/blob/master/81_Search_in_Rotated_Sorted_Array_II
//    SearchinRotatedSortedArrayII_81  (Read here)
    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.print(searchTest(nums, target));
    }

    //low = 0, right = nums.len-1
    //midpt = low+(right-low)/1
    //if nums[midpt] == target return
    //nums[low] <= nums[midpt]   left part is sorter
       //if (nums[low]<= target && nums[midpt] > target) right = midpt-1
       //left = midpt+1
    //nums[midpt]<target && target <= nums[right]
       //left = midpt+1
       //right = midpt-1

    public static int searchTest(int[] nums, int target) {
        int l=0, r = nums.length-1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target) return mid;
            if( (nums[l] == nums[mid]) && (nums[r] == nums[mid])) {l++; r--;}
            else if(nums[l] <= nums[mid]){
                if((nums[l] <= target) && (nums[mid] > target)) r = mid-1;
                else l = mid + 1;
            } else {
                if((nums[mid] < target) && (nums[r] >= target)) l = mid + 1;
                else r = mid-1;
            }
        }
        return -1;
    }


    //binary search to find the index of the lowest element
    //check if the target falls in the first of second part, and binary search again
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left < right) {
            int midpoint = left+(right-left)/2;
            if(nums[midpoint] > nums[right]) {
                left = midpoint+1;
            } else {
                right = midpoint;
            }
        }

        int start = left;
        left = 0;
        right = nums.length-1;

        if (target >= nums[start] && target < nums[right]) {
            left = start;
        } else {
            right = start;
        }

        while(left <= right) {
            int midpoint = left + (right-left)/2;
            if(nums[midpoint] == target) {
                return midpoint;
            } else if (target > nums[midpoint]){
                left = midpoint+1;
            }else {
                right = midpoint-1;
            }
        }
        return -1;
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
