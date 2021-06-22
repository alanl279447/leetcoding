package com.example.ArrayStrings;

public class MaximumSwap_670 {
//    Input: 2736
//    Output: 7236
//    Explanation: Swap the number 2 and the number 7.
//    https://leetcode.com/problems/maximum-swap/
//   time complexity 0(N).
    public static void main(String[] args) {
//        System.out.println(maximumSwap(9973));
        System.out.println(maximumSwap(8745));
    }

    //8745
    //indexMap  -1,-1,-1,2,3,-1,1,0,-1

    //Integer.toString().toCharArray  2,7,3,6
    //int[] positions[10]  -1,-1,0,2,-1,-1,3,1,-1,-1
    // index(2) > index(7) --
    //7,2,3,6
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