package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.List;

public class WiggleSort_280 {
//    Input: nums = [3,5,2,1,6,4]
//    Output: One possible answer is [3,5,1,6,2,4]
//    https://leetcode.com/problems/wiggle-sort/

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[] inputs = {3,5,2,1,6,4};
        wiggleSort(inputs);
        for (int input: inputs)
         System.out.print(input);
    }

    //i%2==1
    //nums[i-1]>nums[i] swap
    //i !=0 && nums[i-1]<nums[i] swap


    public static void wiggleSort(int[] nums) {
        for(int i=0;i<nums.length;i++)
            if(i%2==1){
                if(nums[i-1]>nums[i]) {
                    swap(nums, i);
                }
            }else if(i!=0 && nums[i-1]<nums[i]) {
                swap(nums, i);
            }
    }

    public static void swap(int[] nums, int i){
        int tmp=nums[i];
        nums[i]=nums[i-1];
        nums[i-1]=tmp;
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
