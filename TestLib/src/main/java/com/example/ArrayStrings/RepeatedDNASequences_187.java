package com.example.ArrayStrings;

public class RepeatedDNASequences_187 {

//    Input: [1,2,3,4]
//    Output: 24
//    https://leetcode.com/problems/maximum-product-of-three-numbers/

    public static void main(String[] args) {

        int[] nums = {1,2,3,4};
        System.out.println(maximumProduct(nums));
    }

    public static int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int num: nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return Math.max(max1*max2*max3, min1*min2*max1);
    }
}