package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class MergeIntervals_56 {

//    Input: [[1,3],[2,6],[8,10],[15,18]]
//    Output: [[1,6],[8,10],[15,18]]
//    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
//
//    Input: [[1,4],[4,5]]
//    Output: [[1,5]]
//    Explanation: Intervals [1,4] and [4,5] are considered overlapping.

//    public static TreeNode root = null;
//    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[][] nums1 = {{1,3},{8,10}, {2,6},{15,18}};
        int[][] result = mergeWithoutSort(nums1);
        for (int[] res:result) {
            System.out.print(res[0] +" ");
            System.out.println(res[1]);
        }
    }

    public static int[][] mergeWithoutSort(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];
        List<int[]> list = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int[] itv : intervals){
            map.put(itv[0], map.getOrDefault(itv[0], 0)+1);
            map.put(itv[1], map.getOrDefault(itv[1], 0)-1);
        }
        int count = 0, start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
        for (int k : map.keySet()){
            count+=map.get(k);
            start = Math.min(start, k);
            end = Math.max(end, k);
            if (count==0){
                list.add(new int[]{start, end});
                start = Integer.MAX_VALUE;
                end = Integer.MIN_VALUE;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

    public static int[][] merge(int[][] intervals) {
        int length = intervals.length;
        if (length <=1) {
            return intervals;
        }
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];
        result.add(currentInterval);

        for(int i = 1; i <length;i++) {

            int currentStart = currentInterval[0];
            int currentEnd = currentInterval[1];

            int[] nextInterval = intervals[i];
            int nextStart = nextInterval[0];
            int nextEnd = nextInterval[1];

            if (currentEnd > nextStart) {
                currentInterval[1] = currentEnd > nextEnd ? currentEnd: nextEnd;
            } else {
                result.add(nextInterval);
                currentInterval = nextInterval;
            }
        }
        return result.toArray(new int[result.size()][]);
    }



//    public static int[][] merge(int[][] intervals) {
//        if (intervals.length < 1) {
//            return intervals;
//        }
//        Arrays.sort(intervals, (int[] a, int[]b)-> Integer.compare(a[0], b[0]));
//        List<int[]> result = new ArrayList<>();
//        int[] currentInterval = intervals[0];
//        result.add(currentInterval);
//
//        for (int i = 1; i < intervals.length; i++) {
//          int currentStart = currentInterval[0];
//          int currentEnd = currentInterval[1];
//
//          int nextStart = intervals[i][0];
//          int nextEnd = intervals[i][1];
//
//          if (currentEnd >= nextStart) {
//              currentInterval[1] = currentEnd > nextEnd ? currentEnd: nextEnd;
//          } else {
//              currentInterval = intervals[i];
//              result.add(currentInterval);
//          }
//        }
//       return result.toArray(new int[result.size()][]);
//    }




//    public static int[][] merge(int[][] intervals) {
//        if (intervals.length <=1) {
//            return intervals;
//        }
//        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
//
//        int[] current_interval = intervals[0];
//        List<int[]> values = new ArrayList<>();
//        values.add(current_interval);
//
//        for (int[] interval: intervals) {
//            int currentStart = current_interval[0];
//            int currentEnd = current_interval[1];
//
//            int nextStart = interval[0];
//            int nextEnd = interval[1];
//
//            if (currentEnd >= nextStart) {
//                current_interval[1] = Math.max(currentEnd, nextEnd);
//            } else {
//                current_interval = interval;
//                values.add(interval);
//            }
//        }
//        return values.toArray(new int[values.size()][]);
//    }
}
