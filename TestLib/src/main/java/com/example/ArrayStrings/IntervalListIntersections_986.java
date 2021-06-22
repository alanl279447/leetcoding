package com.example.ArrayStrings;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    //i - first input, j - second input
    //largest start, min end, if (end > start) we hav an overlap

    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j =0;
        List<int[]> lists = new LinkedList<>();
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

    //Input: heights = [4,2,3,1]
    //Output: [0,2,3]
    public int[] findBuildings(int[] hs) {
        if (hs == null || hs.length ==0) return new int[] {};
        Deque<Integer> stack = new ArrayDeque<>();
        int len = hs.length-1;
        int tempMax = hs[len];
        stack.offerFirst(len);
        for (int i = hs.length-2; i >=0; i--) {
            if (hs[i] > tempMax) {
                stack.offerFirst(i);
                tempMax = hs[i];
            }
        }
        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i++] = stack.pollFirst();
        }
        return res;
    }
}