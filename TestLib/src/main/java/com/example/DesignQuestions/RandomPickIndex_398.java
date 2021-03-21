package com.example.DesignQuestions;

import java.util.HashMap;
import java.util.Random;
import java.util.Stack;

public class RandomPickIndex_398 {

//    int[] nums = new int[] {1,2,3,3,3};
//    Solution solution = new Solution(nums);
//
//// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
//solution.pick(3);
//
//// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
//solution.pick(1);
//    https://leetcode.com/problems/random-pick-index/

    public static void main(String[] args) {

        int[] nums = new int[] {1,2,3,3,3};
        Solution minStack = new Solution(nums);
        System.out.println(minStack.pick(1));
        System.out.println(minStack.pick(1));
        System.out.println(minStack.pick(1));
        System.out.println(minStack.pick(1));
        System.out.println(minStack.pick(2));
        System.out.println(minStack.pick(3));
        System.out.println(minStack.pick(3));
        System.out.println(minStack.pick(3));
        System.out.println(minStack.pick(3));
        System.out.println(minStack.pick(3));
        System.out.println(minStack.pick(3));
    }


    class SolutionTest {

        Random random = null;
        int[] numbers = null;
        public SolutionTest(int[] nums) {
           random = new Random();
            numbers = nums;
        }

        public int pick(int target) {
            int index = -1;
            int count = 0;
            for (int i = 0; i < numbers.length; i++) {
                 if (numbers[i] == target) {
                     count++;
                     int randonIndex = random.nextInt(count);
                     if (randonIndex == 0) {
                         index = i;
                     }
                 }
             }
            return index;
        }
    }


    public static class Solution {

        int[] a = null;
        Random random = null;
        public Solution(int[] nums) {
           a = nums;
           random = new Random();
        }

        public int pick(int target) {
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