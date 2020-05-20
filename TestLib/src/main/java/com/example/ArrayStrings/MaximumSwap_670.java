package com.example.ArrayStrings;

public class MaximumSwap_670 {
//    Input: 2736
//    Output: 7236
//    Explanation: Swap the number 2 and the number 7.
//    https://leetcode.com/problems/maximum-swap/
//   time complexity 0(N).
    public static void main(String[] args) {
        System.out.println(maximumSwap(9973));
    }

    public static int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();

        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;
        }

        int max = 9;
        for (int i = 0; i < digits.length; i++) {
            for (int k = max; k > digits[i] - '0'; k--) {
                if (buckets[k] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
            max = digits[i] - '0';
        }
        return num;
    }
}
