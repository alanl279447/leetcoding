package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections_986 {

//    Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
//    Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
//    Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
//    https://leetcode.com/problems/interval-list-intersections/

    public static void main(String args[]) {
        int[][] input1 = {{0,2}, {5,10}, {13,23}, {24,25}};
        int[][] input2 = {{1,5}, {8,12}, {15,24}, {25,26}};
        System.out.println(intervalIntersection(input1, input2));
    }

    public static int[][] intervalIntersection(int[][] A, int[][] B) {

        int i = 0, j =0;
        List<int[]> lists = new ArrayList<>();
        while(i < A.length && j <B.length) {

            int lo = Math.max(A[i][0], B[j][0]); //1
            int hi = Math.min(A[i][1], B[j][1]); //2

            if (lo <= hi) {
               lists.add(new int[] {lo, hi});
            }

            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return lists.toArray(new int[lists.size()][]);
    }
}
