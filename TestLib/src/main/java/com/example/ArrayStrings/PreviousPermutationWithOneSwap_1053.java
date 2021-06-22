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
//https://leetcode.com/problems/previous-permutation-with-one-swap/discuss/299244/Similar-to-find-previous-permutation-written-in-Java
//  0 1 2 3 4
 // 1,9,4,6,7
 // starting from right, first index of A[i] > A[i+1]   A[j] =  1
 // starting from right first index on A[i] < A[j] && nums[i] != nums[i-1]
 // swap(nums, i, j)


public class PreviousPermutationWithOneSwap_1053 {

    public static void main(String[] args) {
        int[] nums = {1,9,4,6,7};
        int[] result = prevPermOpt1Similar(nums);
        System.out.print(Arrays.toString(result));
    }

    //first find the increasing number from right
    //find the first number lower than this number
    //Swap the numbers
    public static int[] prevPermOpt1Similar(int[] A) {
        if (A.length <= 1) return A;
        int idx = -1;
        // find the largest i such that A[i] > A[i + 1]
        for (int i = A.length - 1; i >= 1; i--) {
            if (A[i] < A[i - 1]) {
                idx = i - 1;
                break;
            }
        }
        // the array already sorted, not smaller permutation
        if (idx == -1) return A;
        // find the largest j such that A[j] > A[i], then swap them
        for (int i = A.length - 1; i > idx; i--) {
            // the second check to skip duplicate numbers
            if (A[i] < A[idx] && A[i] != A[i - 1]) {
                int tmp = A[i];
                A[i] = A[idx];
                A[idx] = tmp;
                break;
            }
        }
        return A;
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