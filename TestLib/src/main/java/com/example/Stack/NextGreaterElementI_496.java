package com.example.Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI_496 {

//    Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
//    Output: [-1,3,-1]
//    Explanation:
//    For number 2 in the first array, the next greater number for it in the second array is 3.
//    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
//    https://leetcode.com/problems/next-greater-element-i/

    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1,3,4,2};
        int[] result = nextGreaterElement(nums1, nums2);
        for (int res: result)
         System.out.print(res);
    }

//    int[] nums1 = {4,1,2};
//    int[] nums2 = {1,3,4,2};
    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
