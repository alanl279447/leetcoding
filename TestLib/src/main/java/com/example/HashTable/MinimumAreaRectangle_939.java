package com.example.HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinimumAreaRectangle_939 {
//    Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
//    Output: 4
//    https://leetcode.com/problems/minimum-area-rectangle/
//    time complexity 0(n^2)

    public static void main(String[] args) {
        int[][] input = {{1,1}, {1,3}, {3,1}, {3,3}, {2,2}};
        System.out.println(minAreaRect(input));
    }

    public static int minAreaRectHS(int[][] points) {
       Set<String> set = new HashSet<>();
       for (int[] point: points) {
           set.add(point[0]+"#"+point[1]);
       }
       int minArea = Integer.MAX_VALUE;
      for (int i = 0; i < points.length; i++) {
          for (int j = i+1; j < points.length; j++) {
              if (points[j][0] == points[i][0] || points[j][1] == points[i][1]) continue;

              String point3 = points[i][0]+"#"+points[j][1];
              String point4 = points[j][0]+"#"+points[i][1];
              if (set.contains(point3) && set.contains(point4)) {
                 minArea = Math.min(minArea, Math.abs(points[i][0] - points[j][0]) * Math.abs(points[i][1] - points[j][1]));
              }
          }
      }
       return minArea;
    }

    public static int minAreaRect(int[][] points) {
       HashMap<Integer, Set<Integer>> map = new HashMap<>();
       for (int[] point: points) {
           map.putIfAbsent(point[0], new HashSet<>());
           map.get(point[0]).add(point[1]);
       }
       int min = Integer.MAX_VALUE;
       for (int[] pi: points) {
           for (int[] pj: points) {
               if (pj[0] == pi[0] || pj[1]==pi[1]) continue;
               if (map.get(pj[0]).contains(pi[1]) && map.get(pi[0]).contains(pj[1])) {
                   min = Math.min(min, Math.abs(pi[0] - pj[0]) * Math.abs(pi[1] - pj[1]));
               }
           }
       }
       return min == Integer.MAX_VALUE ? 0 : min;
    }
}
