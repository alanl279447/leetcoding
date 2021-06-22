package com.example.Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class NextGreaterElementII_503 {

//    Input: [1,2,1]
//    Output: [2,-1,2]
//    Explanation: The first 1's next greater number is 2;
//    The number 2 can't find next greater number;
//    The second 1's next greater number needs to search circularly, which is also 2.
//    https://leetcode.com/problems/next-greater-element-ii/

    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[] input = {1,2,1};
        int[] result = nextGreaterElements(input);
        for (int res: result)
         System.out.print(res);
    }

    //2,-1,2
    public static int[] nextGreaterElements(int[] nums) {
         Stack<Integer> stack = new Stack();
         int n = nums.length;
         int[] result = new int[n];
         Arrays.fill(result,-1);

         for(int i=0; i<2*n;i++) {
           int num = nums[i%n];
           while (!stack.isEmpty() && nums[stack.peek()]< num) {
               result[stack.pop()]=num;
           }
           if (i<n) {
               stack.push(i);
           }
         }
         return result;
    }

    //    public static int[] nextGreaterElementsPrac(int[] nums) {
//        Stack<Integer> stack = new Stack<>();
//        int[] result = new int[nums.length];
//        for (int i=0; i < 2*nums.length;i++) {
//            int num = nums[i%nums.length];
//            while(!stack.isEmpty() && num > (nums[stack.peek()])) {
//                result[stack.peek()]=num;
//                if (i<nums.length) {
//                    stack.push(i);
//                }
//            }
//        }
//
//    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
