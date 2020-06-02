package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FrogJump_403 {

//    Input: [3,2,1,5,6,4] and k = 2
//    Output: 5
//
//    Input: [3,2,3,1,2,4,5,5,6] and k = 4
//    Output: 4

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[] nums1 = {3,1,2,5,6,4};
        System.out.print(findKthLargest(nums1, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length - 1, index = nums.length - k;
        while (start <= end) {
            int pivot = partion(nums, start, end);
            if (pivot < index) start = pivot + 1;
            else if (pivot > index) end = pivot - 1;
            else return nums[pivot];
        }
        return nums[start];
    }

    private static int partion(int[] nums, int start, int end) {
        int pivot = start;
        while (start <= end) {
            while (start <= end && nums[start] <= nums[pivot]) start++;
            while (start <= end && nums[end] > nums[pivot]) end--;
            if (start > end) break;
            swap(nums, start, end);
        }
        swap(nums, end, pivot);
        return end;
    }

    private static void swap(int[] nums, int pivot, int right) {
        nums[pivot] = nums[pivot]+nums[right];
        nums[right] = nums[pivot]-nums[right];
        nums[pivot] = nums[pivot]-nums[right];
    }


    public static int findKthLargestQueue(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int num: nums) {
             queue.add(num);
             if(queue.size() > k) {
              queue.poll();
            }
        }
        return queue.peek();
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
