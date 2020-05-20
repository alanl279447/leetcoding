package com.example.ArrayStrings;

import java.util.Stack;

//        Input: [10,9,2,5,3,7,101,18]
//        Output: 4
//        Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
//        https://leetcode.com/problems/longest-increasing-subsequence/

public class LongestIncreasingSubsequence_300 {

    public static void main(String[] args) {
        int[] input = {10,9,2,5,3,7,101,18};
       // int[] input = {4,5,6,3};
        int result = lengthOfLIS(input);
        System.out.print(result);
    }

   // int n =nums.length, len=0
   // increase[len++] = nums[0]
   // for i=1, i < n; i++
   // if (nums[i]>increase[len-1]
   //increase[len++] = nums[i]
   //else finPosition(incraseArray, 0, len-1, nums[i])

    public static int lengthOfLIS(int[] nums) {
        if (nums == null | nums.length == 0)
            return 0;
        int n = nums.length, len = 0;
        int[] increasingSequence = new int[n];
        increasingSequence[len++] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > increasingSequence[len - 1])
                increasingSequence[len++] = nums[i];
            else {
                int position = findPositionToReplace(increasingSequence, 0, len - 1, nums[i]);
                increasingSequence[position] = nums[i];
            }
        }
        return len;
    }

    public static int findPositionToReplace(int[] a, int low, int high, int x) {
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (a[mid] == x)
                return mid;
            else if (a[mid] > x)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
}
