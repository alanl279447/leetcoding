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
        int[] nums = {2,5,6,0,0,1,2};
        int target = 1;
        System.out.print(search(nums, target));
    }

    //2,5,6,0,0,1,2
    public static boolean search(int[] nums, int target) {
        int start  = 0, end = nums.length - 1;

        //check each num so we will check start == end
        //We always get a sorted part and a half part
        //we can check sorted part to decide where to go next
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target) return true;

            //if left part is sorted
            if(nums[start] < nums[mid]){
                if(target < nums[start] || target > nums[mid]){
                    //target is in rotated part
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }else if(nums[start] > nums[mid]){  //2,5,6,0,0,1,2
                //right part is rotated

                //target is in rotated part
                if(target < nums[mid] || target > nums[end]){
                    end = mid -1;
                }else{
                    start = mid + 1;
                }
            }else{
                //duplicates, we know nums[mid] != target, so nums[start] != target
                //based on current information, we can only move left pointer to skip one cell
                //thus in the worest case, we would have target: 2, and array like 11111111, then
                //the running time would be O(n)
                start ++;
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
