package com.example.ArrayStrings;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
//        Input: [1,9,4,6,7]
//        Output: [1,7,4,6,9]
//        Explanation: Swapping 9 and 7.
//
//        Input: [3,1,1,3]
//        Output: [1,3,1,3]
//        Explanation: Swapping 1 and 3.
//        https://leetcode.com/problems/previous-permutation-with-one-swap/

public class PreviousPermutationWithOneSwap_1053 {

    public static void main(String[] args) {
        int[] nums = {1,9,4,6,7};
        int[] result = prevPermOpt1(nums);
        System.out.print(Arrays.toString(result));
    }

    public static int[] prevPermOpt1(int[] A) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i = A.length-1; i >= 0; i--) {
            int v = A[i];
            Integer key = map.lowerKey(v);

            map.put(v, i);
            if(key == null) {
                continue;
            }
            Integer higher = map.get(key);

            if(higher != null) {
                swap(A, i, higher);
                break;
            }
        }
        return A;
    }

    static void swap(int[] A, int i1, int i2) {
        A[i1] = A[i1] ^ A[i2];
        A[i2] = A[i1] ^ A[i2];
        A[i1] = A[i1] ^ A[i2];
    }

}
