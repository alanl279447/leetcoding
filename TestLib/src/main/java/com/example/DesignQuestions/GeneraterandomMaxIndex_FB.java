package com.example.DesignQuestions;

import java.util.Random;

public class GeneraterandomMaxIndex_FB {

//    Given an array of integers arr, randomly return an index of the maximum value seen by far.
//    Example:Input: [11, 30, 2, 30, 30, 30, 6, 2, 62, 62]
//    Having iterated up to the at element index 5 (where the last 30 is), randomly give an index among [1, 3, 4, 5] which are indices of 30 - the max value by far. Each index should have a ¼ chance to get picked.
//    Having iterated through the entire array, randomly give an index between 8 and 9 which are indices of the max value 62.
//    https://leetcode.com/discuss/interview-question/451431/Facebook-or-Onsite-or-Generate-random-max-index

    public static void main(String[] args) {

        int[] nums = new int[] {1,2,3,3,3};
        Solution minStack = new Solution(nums);
        System.out.println(minStack.pick(3));
        System.out.println(minStack.pick(3));
        System.out.println(minStack.pick(3));
        System.out.println(minStack.pick(3));
        System.out.println(minStack.pick(3));
        System.out.println(minStack.pick(3));

//        minStack.pick(1);
    }

    public static class Solution {

        static int[] a = null;
        static Random random = null;
        public Solution(int[] nums) {
           a = nums;
           random = new Random();
        }

        public static int pick(int target) {
            int count = 0;
            int res = 0;

            for (int i = 0; i < a.length; i++) {
                if (a[i] == target) {
                    count++;

                    int index = random.nextInt(count);
                    if (index == 0) {
                        res = i;
                    }
                }
            }

            return res;
        }
    }

}
