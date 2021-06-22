package com.example.DynamicProgramming;

import java.util.Arrays;

public class BurstBalloons_312 {

//    Input: points = [[10,16],[2,8],[1,6],[7,12]]
//    Output: 2
//    Explanation: One way is to shoot one arrow for example at x = 6
//            (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11
//            (bursting the other two balloons).
//    https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

    public static void main(String[] args) {
        int[][] points = {{10,16}, {2,8}, {1,6}, {7,12}};
        System.out.print(findMinArrowShots(points));
    }

    //1,6  2,8  7,12  10,16

    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int arrowPos = points[0][1];
        int arrowCnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0]) {
                continue;
            }
            arrowCnt++;
            arrowPos = points[i][1];
        }
        return arrowCnt;
    }
}
