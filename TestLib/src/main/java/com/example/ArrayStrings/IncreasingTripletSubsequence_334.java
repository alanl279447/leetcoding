package com.example.ArrayStrings;

//Return true if there exists i, j, k
//such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
//Input: [1,2,3,4,5]
//Output: true
//https://leetcode.com/problems/increasing-triplet-subsequence/
public class IncreasingTripletSubsequence_334 {
    public static void main(String[] args) {
        int[] A = {3,2,1,3,2,0,4};
        System.out.println(increasingTriplet(A));
    }

    public static boolean increasingTriplet(int[] nums) {
        int first_num = Integer.MAX_VALUE;
        int second_num = Integer.MAX_VALUE;
        for (int n: nums) {
            if (n <= first_num) {
                first_num = n;
            } else if (n <= second_num) {
                second_num = n;
            } else {
                return true;
            }
        }
        return false;
    }
}