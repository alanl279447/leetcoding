package com.example.DesignQuestions;

import java.util.Random;

public class RandomPickwithWeight_528 {

//    Given an array w of positive integers, where w[i] describes the weight of index i,
//    write a function pickIndex which randomly picks an index in proportion to its weight.
//   https://leetcode.com/problems/random-pick-with-weight/

    public static void main(String[] args) {

        int[] nums = new int[] {1,3,1,5};
        Solution minStack = new Solution(nums);
        System.out.println(minStack.pickIndex());
    }

    public static class Solution {
        Random random;
        int[] wSums;

        public Solution(int[] w) {
            this.random = new Random();
            for(int i=1; i<w.length; ++i)
                w[i] += w[i-1];
            this.wSums = w;
        }

        public int pickIndex() {
            int len = wSums.length;
            int idx = 7;//random.nextInt(wSums[len-1]) + 1;   // +1 is needed to offset 0
            int left = 0, right = len - 1;
            // search position
            while(left < right){
                int mid = left + (right-left)/2;
                if(wSums[mid] == idx)
                    return mid;
                else if(wSums[mid] < idx)
                    left = mid + 1;
                else
                    right = mid;
            }
            return left;
        }
    }
}