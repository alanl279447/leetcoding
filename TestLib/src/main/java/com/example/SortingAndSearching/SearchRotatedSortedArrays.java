package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.List;

public class SearchRotatedSortedArrays {

//    Input: nums = [4,5,6,7,0,1,2], target = 0
//    Output: 4
//
//    Input: nums = [4,5,6,7,0,1,2], target = 3
//    Output: -1

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[] nums = {3,4,5,0,1,2};
        int target = 1;
        System.out.print(search(nums, target));
    }

    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;
        int midpoint = left+(right-left)/2;

        while(left < right) {
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
            midpoint = left + (right-left)/2;
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


//    public static int search(int[] nums, int target) {
//        int start = 0, end = nums.length - 1;
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//            if (nums[mid] == target) return mid;
//            else if (nums[mid] > nums[start]) {
//                if (target > nums[start] && target < nums[mid]) {
//                    end = mid -1;
//                } else {
//                    start = mid+1;
//                }
//            } else {
//                if (target > nums[mid] && target <= nums[end]) {
//                    start = mid+1;
//                } else {
//                    end = mid -1;
//                }
//            }
//        }
//        return -1;
//    }

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
