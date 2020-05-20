package com.example.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MaxPointsonaLine_149 {

    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {

//        int[][] points = {{1,1}, {3,2}, {5,3}, {4,1}, {2,3}, {1,4}};
        int[][] points = {{1,1}, {2,2}, {3,3}};
//        int[][] points = {{0,0}, {0,0}};
        System.out.print(maxPoints(points));
    }

    public static int maxPoints(int[][] points) {
        int length = points.length;
        int externalMax = 0;
        if (length < 2) return length;
        Set<String> set = new HashSet<>();

        for (int i=0; i <length && !set.contains(points[i][0] + "-" +points[i][1]); i++) {
            int[] a = points[i];
            int same = 0;
            int maxLocal = 0;
            Map<Double, Integer> map = new HashMap<>();
            for (int j = i+1; j<length;j++) {
                if (isSame(a, points[j])) {
                    same++;
                    continue;
                }
              Double slope = getSlope(a, points[j]);
              map.put(slope, map.getOrDefault(slope, 1)+1);
              maxLocal = Math.max(maxLocal, map.get(slope));
            }
            set.add(a[0]+"-"+a[1]);
            externalMax = Math.max(externalMax, maxLocal+same);
        }
        return externalMax;
    }

    public static double getSlope(int[] a, int[] b) {
        if (a[0]==b[0])return Double.MAX_VALUE;
        if(a[1]==b[1]) return 0;
        else {
            return  (double)(a[0]-b[0])/(double)(a[1]-b[1]);
        }
    }

    public static boolean isSame(int[] a, int[] b) {
        return a[0] == b[0] && a[1] ==b[1];
    }

}
