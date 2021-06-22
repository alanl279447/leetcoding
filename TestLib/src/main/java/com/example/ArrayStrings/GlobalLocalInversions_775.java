package com.example.ArrayStrings;

public class GlobalLocalInversions_775 {

//    Input: A = [1,2,0]
//    Output: false
//    Explanation: There are 2 global inversions, and 1 local inversion.
//    https://leetcode.com/problems/global-and-local-inversions/
//    The number of (global) inversions is the number of i < j with 0 <= i < j < N and A[i] > A[j].   1 > 0, 2 > 0 = 2
//    The number of local inversions is the number of i with 0 <= i < N and A[i] > A[i+1].            2 > 0 = 1

    public static void main(String[] args) {
        int[] input = {1,2,0};
        System.out.println(isIdealPermutation(input));
    }

//    All local inversions are global inversions.
//    If the number of global inversions is equal to the number of local inversions,
//    it means that all global inversions in permutations are local inversions.
//    It also means that we can not find A[i] > A[j] with i+2<=j.
//    In other words, max(A[i]) < A[i+2]
    public static boolean isIdealPermutation(int[] A) {
        int max = -1;
        for(int i = 0; i < A.length-2; i++) {
            max = Math.max(max, A[i]);
            if(max > A[i+2])
                return false;
        }
        return true;
    }
}