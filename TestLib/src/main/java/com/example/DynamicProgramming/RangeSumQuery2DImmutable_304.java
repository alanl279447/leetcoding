package com.example.DynamicProgramming;

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
//    https://leetcode.com/problems/range-sum-query-2d-immutable/discuss/75358/Clean-and-easy-to-understand-java-solution
//     time complexity o(1) - sumRange, 0(mn) for initial setup

    public static void main(String[] args) {
        //int[][] matrix = {{3,0,1,4,2}, {5,6,3,2,1}, {1,2,0,1,5}, {1,0,3,0,5}};
        int[][] matrix = {{3, 0}, {5, 8}};
        NumMatrix obj = new NumMatrix(matrix);
       int param_1 = obj.sumRegion(1,1,1,1);
        System.out.print(param_1);
    }

    static class NumMatrix {
        int[][] sum;
        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0) return;
            int m = matrix.length, n = matrix[0].length;
            sum = new int[m + 1][n + 1]; // sum[i][j] is sum of all elements from rectangle (0,0,i,j) as left, top, right, bottom corresponding
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }
        public int sumRegion(int r1, int c1, int r2, int c2) {
            r1++; c1++; r2++; c2++; // Since `sum` start with 1 so we need to increase r1, c1, r2, c2 by 1
            return sum[r2][c2] - sum[r2][c1 - 1] - sum[r1 - 1][c2] + sum[r1 - 1][c1 - 1];
        }
    }
}
//0,0,0
//0,3,3
//0,5,