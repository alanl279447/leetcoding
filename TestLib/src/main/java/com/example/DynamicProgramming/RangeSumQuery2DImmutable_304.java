package com.example.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RangeSumQuery2DImmutable_304 {

//    Given matrix = [
//            [3, 0, 1, 4, 2],
//            [5, 6, 3, 2, 1],
//            [1, 2, 0, 1, 5],
//            [4, 1, 0, 1, 7],
//            [1, 0, 3, 0, 5]
//            ]
//
//    sumRegion(2, 1, 4, 3) -> 8
//    sumRegion(1, 1, 2, 2) -> 11
//    sumRegion(1, 2, 2, 4) -> 12
//    https://leetcode.com/problems/range-sum-query-2d-immutable/

    public static void main(String[] args) {
        int[][] matrix = {{3,0,1,4,2}, {5,6,3,2,1}, {1,2,0,1,5}, {1,0,3,0,5}};
        NumMatrix obj = new NumMatrix(matrix);
       int param_1 = obj.sumRegion(2,1,4,3);
        System.out.print(param_1);
    }

    static class NumMatrix {
        private int[][] dp;


        public NumMatrix( int[][] matrix){
           int row = matrix.length;
           int column = matrix[0].length;
           if (row ==0 || column ==0) return;
           for (int i=0; i < row; i++) {
               for (int j =0; j < column; j++) {
                   dp[i][j+1] = dp[i][j] + matrix[i][j];
               }
           }
        }

        public int sumRegion ( int row1, int col1, int row2, int col2){
            int sum = 0;
            for (int row = row1; row <= row2; row++) {
                sum += dp[row][col2 + 1] - dp[row][col1];
            }
            return sum;
        }
    }

}
