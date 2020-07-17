package com.example.DynamicProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Triangle_120 {

//[
//        [2],
//        [3,4],
//        [6,5,7],
//        [4,1,8,3]
//        ]
//    The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
//    https://leetcode.com/problems/triangle/

    public static void main(String[] args) {
        Integer[][] prices = {{2}, {3,4}, {6,5,7}, {4,1,8,3}};
        List<List<Integer>> pricesInt = Arrays.stream(prices).map(Arrays::asList).collect(Collectors.toList());
        System.out.print(minimumTotal(pricesInt));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int rows = triangle.size();
        int[] dp = new int[rows+1];

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j]=Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
