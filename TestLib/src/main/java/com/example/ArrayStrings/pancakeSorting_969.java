package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.List;

public class pancakeSorting_969 {

//    Input: [3,2,4,1]
//    Output: [4,2,4,3]
//    Explanation:
//    We perform 4 pancake flips, with k values 4, 2, 4, and 3.
//    Starting state: A = [3, 2, 4, 1]
//    After 1st flip (k=4): A = [1, 4, 2, 3]
//    After 2nd flip (k=2): A = [4, 1, 2, 3]
//    After 3rd flip (k=4): A = [3, 2, 1, 4]
//    After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted.
//    https://leetcode.com/problems/pancake-sorting/
//    time complexity 0(N^2)
    public static void main(String args[]) {
        int[] input = {3,2,4,1};
        List<Integer> res = pancakeSort(input);
        for(Integer re: res)
          System.out.println(re);
    }

//    public static List<Integer> pancakeSortPrac(int[] A) {
//        List<Integer> result = new ArrayList<>();
//        int n = A.length, largest = n;
//        for (int i=0; i < n; i++) {
//            int index = find(A, largest);
//            if(index==largest-1) {
//                continue;
//            }
//            flipPrac(A, index);
//            flipPrac(A, largest-1);
//            result.add(index+1);
//            result.add(largest--);
//        }
//    }

//    public static void flipPrac(int[]A, int index) {
//        int i=0, j = index;
//        while(i<index) {
//            int temp=A[i];
//            A[i++]=A[index];
//            A[index--]=temp;
//        }
//    }


    public static List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new ArrayList<>();
        int n = A.length, largest = n;
        for (int i = 0; i < n; i++) {
            int index = find(A, largest);
            if(index==largest-1) {
                continue;
            }
            flip(A, index);
            flip(A, largest - 1);
            result.add(index + 1);
            result.add(largest--);
        }
        return result;
    }
    private static int find(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                return i;
            }
        }
        return -1;
    }
    private static void flip(int[] A, int index) {
        int i = 0, j = index;
        while (i < j) {
            int temp = A[i];
            A[i++] = A[j];
            A[j--] = temp;
        }
    }
}
