package com.example.ArrayStrings;

public class MonotonicArray_896 {
//    Input: [1,2,2,3]
//    Output: true
//    https://leetcode.com/problems/monotonic-array/

    public static void main(String[] args) {
        int[] s = {1,2,2,3};
        System.out.println(isMonotonic(s));
    }

    public static boolean isMonotonic(int[] A) {
        boolean decreasing = true, increasing = false;

        for (int i=1; i < A.length; i++) {
           if (A[i]>A[i-1]) {
               decreasing=false;
           }
           if (A[i]<A[i-1]){
               increasing=false;
           }
        }
        return increasing||decreasing;
    }

}
