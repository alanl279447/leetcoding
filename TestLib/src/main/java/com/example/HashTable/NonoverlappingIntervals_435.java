package com.example.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class NonoverlappingIntervals_435 {

//    Input: [[1,2],[2,3],[3,4],[1,3]]
//    Output: 1
//    Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
//            https://leetcode.com/problems/non-overlapping-intervals/

//    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {

        int[][] input = {{1,2}, {2,3}, {3,4}, {1,3}};
        int result = eraseOverlapIntervalsTest(input);
        System.out.println(result);
    }

    //Time complexity is 0(nlogn)
    public static int eraseOverlapIntervalsTest(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[1]-b[1]);
        int count = 1;
        int end = intervals[0][1];

        for (int i=1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length-count;
    }

    // (1,2), (2,3), (1,3), (3,4)
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0)  return 0;

        Arrays.sort(intervals, new myComparator());
        int end = intervals[0][1];
        int count = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }

    static class myComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[1] - b[1];
        }
    }


}
