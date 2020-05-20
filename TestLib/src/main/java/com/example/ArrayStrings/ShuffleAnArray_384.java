package com.example.ArrayStrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ShuffleAnArray_384 {

    // Init an array with set 1, 2, and 3.
//    int[] nums = {1,2,3};
//    Solution solution = new Solution(nums);
//
//// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
//solution.shuffle();
//
//// Resets the array back to its original configuration [1,2,3].
//solution.reset();
//
//// Returns the random shuffling of array [1,2,3].
//solution.shuffle();
//    https://leetcode.com/problems/shuffle-an-array/

    public static void main(String args[]) {

        int[] input = {1,2,3};
        Solution obj = new Solution(input);
        int[] param_1 = obj.reset();
        for (int param:param_1) {
            System.out.println(param);
        }
        int[] param_2 = obj.shuffle();
        for (int param:param_2) {
            System.out.println(param);
        }
    }

    static class Solution {
        private int[] array;
        private int[] original;

        Random rand = new Random();
        private int randRange(int min, int max) {
            return rand.nextInt(max - min) + min;
        }

        private void swapAt(int i, int j) {
            ///int temp = array[i];
            array[i] = array[i] ^ array[j];
            array[j] = array[i] ^ array[j];
            array[i] = array[i] ^ array[j];
        }

        public Solution(int[] nums) {
            array = nums;
            original = nums.clone();
        }

        public int[] reset() {
            array = original;
            original = original.clone();
            return original;
        }

        public int[] shuffle() {
            for (int i = 0; i < array.length; i++) {
                swapAt(i, randRange(i, array.length));
            }
            return array;
        }
    }

}
