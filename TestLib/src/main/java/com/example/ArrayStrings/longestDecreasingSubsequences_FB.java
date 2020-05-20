package com.example.ArrayStrings;

import java.util.HashSet;
import java.util.Set;

public class longestDecreasingSubsequences_FB {

//    Input: [2, 9, 12, 13, 4, 7, 6, 5, 10]
//    Output: 4
//    Explanation: [2], [9, 4], [12, 10], [13, 7, 6, 5]
//    https://leetcode.com/discuss/interview-question/350233/google-summer-intern-oa-2019-decreasing-subsequences
//    Time complexity 0(nlogn)

    public static void main(String args[]) {
//        int[] input = {100, 4, 200, 1, 3, 2};
        int res = leastSubsequences(2, 9, 12, 13, 4, 7, 6, 5, 10);
        System.out.println(res);
    }

    public static int leastSubsequences(int... nums) {
        int[] piles = new int[nums.length];
        int size = 0;
        for (int val : nums) {
            int pile = binarySearch(piles, 0, size, val);
            piles[pile] = val;
            if (pile == size) {
                size++;
            }
        }
        return size;
    }

    // find first element greater than target
    public static int binarySearch(int[] nums, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = (lo + hi) /2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target) {
                hi = mid-1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    //    2,
//    9,4,
//    12,7,6,5,
//    13,10
    public static int leastSubsequencesPrac(int... nums) {
        int[] piles = new int[nums.length];
        int size = 0, pile = 0;
        for (int i =0; i < nums.length; i++) {
            pile = binarySearchPrac(piles, 0, size, nums[i]);
            piles[pile] = nums[i];
            if (pile == size) {
                size++;
            }
        }
        return size;
    }

    //element greater than target
    public static int binarySearchPrac(int[] piles, int lo, int high, int target) {
        while (lo <= high) {
            int mid = lo + (high-lo)/2;
            if (piles[mid]==target) break;
            else if (piles[mid]> target) {
                lo =mid+1;
            } else {
                high=mid-1;
            }
        }
        return lo;
    }

//    public static void main(String[] args) {
//        test(leastSubsequences(2, 9, 12, 13, 4, 7, 6, 5, 10), 4);
//        test(leastSubsequences(5, 2, 4, 3, 1, 6), 3);
//        test(leastSubsequences(1, 1, 1), 3);
//    }
}
