package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SortColors75 {
//
//    Input: [2,0,2,1,1,0]
//    Output: [0,0,1,1,2,2]
//    https://leetcode.com/problems/sort-colors/

    public static TreeNode root = null;
    public static void main(String[] args) {
        int[] input = {2,0,2,1,1,0};
//        int[] input = {2,0,1};
        sortColors(input);
        for (int inp: input) {
            System.out.println(inp);
        }
    }

    public static void sortColors(int[] nums) {
        int start=0, end = nums.length-1, index=0;
        while (index<=end) {
            if (nums[index]==0) {
                nums[index]=nums[start];
                nums[start]=0;
                start++;
                index++;
            } else if (nums[index]==2) {
                nums[index]=nums[end];
                nums[end]=2;
                end--;
            } else {
                index++;
            }
        }
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
