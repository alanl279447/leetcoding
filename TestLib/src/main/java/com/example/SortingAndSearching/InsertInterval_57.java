package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class InsertInterval_57 {
//    Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//    Output: [[1,2],[3,10],[12,16]]
//    Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
//    https://leetcode.com/problems/insert-interval/
    public static void main(String[] args) {
        int[][] nums1 = {{1,2},{3,5}, {6,7},{8,10}, {12,16}};
        int[] newInterval = {4,8};
        int[][] result = insert(nums1, newInterval);
        for (int[] res:result) {
            System.out.println(res[0] +" "+res[1]);
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();

        int i = 0;
        while(i<n && intervals[i][1]<newInterval[0]){
            ans.add(intervals[i++]);
        }

        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0]= Math.min(intervals[i][0], newInterval[0]);
            newInterval[1]= Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        ans.add(newInterval);

        while(i<n){
            ans.add(intervals[i++]);
        }

        return ans.toArray(new int[ans.size()][]);
    }

}
