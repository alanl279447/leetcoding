package com.example.DesignQuestions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class SlidingWindowMaximum_239 {
//    Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
//    Output: [3,3,5,5,6,7]
//    Explanation:
//
//    Window position                Max
//---------------               -----
//        [1  3  -1] -3  5  3  6  7       3
//        1 [3  -1  -3] 5  3  6  7       3
//        1  3 [-1  -3  5] 3  6  7       5
//        1  3  -1 [-3  5  3] 6  7       5
//        1  3  -1  -3 [5  3  6] 7       6
//        1  3  -1  -3  5 [3  6  7]      7
//    https://leetcode.com/problems/sliding-window-maximum/

    public static void main(String[] args) {

        int[] nums = {1,3,-1,-3,5,3,6,7};
//        int[] nums = {1,3,-1,-3};    //3,3
//        int[] nums = {1,2,3,4};    //3,4
        int[] result = maxSlidingWindow(nums, 3);
        for (int res: result) {
            System.out.println(res);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k > nums.length) {
            return new int[0];
        }
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[nums.length-k+1];
        int  i = 0;
        while(i<nums.length) {
            if(!dq.isEmpty() && dq.peekFirst()==i-k) {
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.addLast(i);
            if (i>=k-1) {
                result[i-k+1] = nums[dq.peekFirst()];
            }
            i++;
        }
        return result;
    }



//    public static int[] maxSlidingWindow(int[] nums, int k) {
//        if (nums == null || nums.length ==0 || k > nums.length) {
//            return new int[0];
//        }
//
//        int[] res = new int[nums.length-k+1];
//        Deque<Integer> dq = new ArrayDeque<>();
//        int i = 0;
//
//        while(i<nums.length) {
//            if(!dq.isEmpty() && dq.peekFirst() == i-k) {
//                dq.pollFirst();
//            }
//            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
//                dq.pollLast();
//            }
//            dq.offerLast(i);
//            if (i >= k-1) {
//                res[i-k+1] = nums[dq.peekFirst()];
//            }
//            i++;
//        }
//        return res;
//    }

//    public static int[] maxSlidingWindow(int[] nums, int k) {
//        int length = nums.length;
//        int[] result = new int[length -k +1];
//
//        for (int i=0; i< length-k+1; i++) {
//            int maxElement = Integer.MIN_VALUE;
//            for (int j=i; j<i+k; j++) {
//              maxElement = Math.max(maxElement, nums[j]);
//          }
//           result[i] = maxElement;
//        }
//        return result;
//    }
}
