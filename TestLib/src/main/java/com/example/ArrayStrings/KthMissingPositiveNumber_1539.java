package com.example.ArrayStrings;
//        Input: arr = [2,3,4,7,11], k = 5
//        Output: 9
//        Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
//        https://leetcode.com/problems/kth-missing-positive-number/

public class KthMissingPositiveNumber_1539 {
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        System.out.println(findKthPositive(arr, 5));
    }

//    Assume the final result is x,
//    And there are m number not missing in the range of [1, x].
//    Binary search the m in range [0, A.size()].
//
//    If there are m number not missing,
//    that is A[0], A[1] .. A[m-1],
//    the number of missing under A[m] - 1 is A[m] - 1 - m.
//
//    If A[m] - 1 - m < k, m is too small, we update left = m.
//            If A[m] - 1 - m >= k, m is big enough, we update right = m.
//
//            Note that, we exit the while loop, l = r,
//    which equals to the number of missing number used.
//    So the Kth positive number will be l + k.

    public static int findKthPositive(int[] arr, int k) {
        int l = 0, r = arr.length, m = 0;
        while (l < r) {
            m = (l + r) / 2;
            if (arr[m] - 1 - m < k)
                l = m + 1;
            else
                r = m;
        }
        return l + k;
    }
}