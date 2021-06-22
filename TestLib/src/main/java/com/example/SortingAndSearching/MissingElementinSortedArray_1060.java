package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingElementinSortedArray_1060 {

//    Input: nums = [4,7,9,10], k = 3
//    Output: 5
//    Explanation:
//    The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
//    https://leetcode.com/problems/missing-element-in-sorted-array/
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[] nums1 = {4,7,9,10};
//        System.out.print(missingElement(nums1, 3));
        System.out.print(missingElementFast(nums1, 3));
    }

    //{4,7,9,10}
    //nums[i] -nums[0] - i  =  7 - 4 - 1 = 2
    //7+3-2=8

//    https://www.youtube.com/watch?v=eLDT92Q0D9U
    public static int missingElementFast(int[] nums, int k) {
       int lo = 0, high = nums.length;   //high is nums.length
       while (lo < high) {
           int midpt = lo+(high-lo)/2;
           if (numsMissing(nums, midpt) < k) {
               lo = midpt+1;
           } else {
               high = midpt;
           }
       }
       return nums[lo-1]-numsMissing(nums, lo-1) + k;
    }

    public static int numsMissing(int[] nums, int i) {
        int temp = nums[i]-nums[0]-i;
        return temp;
    }

//    public static int missingElement(int[] nums, int k) {
//        int len = nums.length;
//        int lo = 0, hi = len - 1;
//        int countMissing = nums[len - 1] - nums[0] + 1 - len;   //10-4-4+1  = 2
//
//        if (countMissing < k) {
//            return nums[len - 1] + k - countMissing;
//        }
//        while (lo < hi - 1) {
//            int mid = lo + (hi - lo) / 2;
//            int newCountMissing = nums[mid] - nums[lo] - (mid - lo);
//
//            if (newCountMissing >= k) {
//                hi = mid;
//            } else {
//                k -= newCountMissing;
//                lo = mid;
//            }
//        }
//        return nums[lo] + k;
//    }
}