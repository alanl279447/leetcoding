package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
//Input: A = [34,23,1,24,75,33,54,8], K = 60
//        Output: 58
//        Explanation:
//        We can use 34 and 24 to sum 58 which is less than 60.
//        https://leetcode.com/problems/two-sum-less-than-k/

public class TwoSumLessThanK_1099 {

    public static void main(String[] args) {
        int nums[] = {34,23,1,24,75,33,54,8};
        System.out.println("Start main " +twoSumLessThanK(nums, 60));
    }

    public static int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);    //10,20,30,40 .  K 15
        int i = 0, j = A.length-1;
        int max = -1;
        while(i < j) {
            int sum = A[i] + A[j];
            if (sum < K) {
                max = Math.max(max, sum);
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
