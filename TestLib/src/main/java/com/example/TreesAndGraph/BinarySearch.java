package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

//    Input: nums = [-1,0,3,5,9,12], target = 9
//    Output: 4
//    Explanation: 9 exists in nums and its index is 4

    public static TreeNode root;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
//        addNode(1);
        int[] nums = {-1,0,3,5,9,12};
        System.out.print(searchTest(nums, 9));
    }

    public static int searchTest(int[] nums, int target) {
        int start = 0, end = nums.length;
        while (start <= end) {
            int midpoint = start + (end-start)/2;
            if (nums[midpoint]>target) {
                end = midpoint-1;
            } else if (nums[midpoint]<target) {
                start = midpoint+1;
            } else {
                return midpoint;
            }
        }
        return -1;
    }

    public static int search(int[] nums, int target) {
        int result = 0;
        result = searchInner(nums, 0, nums.length-1,target);
        return result;
    }

    public static int searchInner(int[] nums, int start, int end, int target) {
        if(start > end) return -1;
        int midpoint = start + (end-start)/2;
        if (nums[midpoint] == target) {
            return midpoint;
        }else if (nums[midpoint] < target) {
            return searchInner(nums, midpoint+1, end, target);
        } else {
            return searchInner(nums, start, midpoint-1, target);
        }
    }


//    public static int depth(TreeNode node) {
//        if (node == null) return 0;
//        int L = depth(node.left);
//        int R = depth(node.right);
//        ans = Math.max(ans, L+R+1);
//        return Math.max(L, R) + 1;
//    }
//
//    public static void addNode(int value) {
//        root = new TreeNode(value);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
////        root.right.left = new TreeNode(7);
////        root.right.right = new TreeNode(8);
//    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
