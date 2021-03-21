package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingElementinSortedArray_1060 {

//    Input: A = [1,2,4], K = 3
//    Output: 6
//    Explanation:
//    The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
//    https://leetcode.com/problems/missing-element-in-sorted-array/
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[] nums1 = {4,7,9,10};
        System.out.print(missingElement(nums1, 3));
    }

    public static int missingElement(int[] nums, int k) {
        int len = nums.length;
        int lo = 0, hi = len - 1;
        int countMissing = nums[len - 1] - nums[0] + 1 - len;

        if (countMissing < k) {
            return nums[len - 1] + k - countMissing;
        }
        while (lo < hi - 1) {
            int mid = lo + (hi - lo) / 2;
            int newCountMissing = nums[mid] - nums[lo] - (mid - lo);

            if (newCountMissing >= k) {
                hi = mid;
            } else {
                k -= newCountMissing;
                lo = mid;
            }
        }
        return nums[lo] + k;
    }
}