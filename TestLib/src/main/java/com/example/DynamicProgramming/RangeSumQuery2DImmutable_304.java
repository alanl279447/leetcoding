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
       int param_1 = obj.sumRegion(,1,4,3);
        System.out.print(param_1);
    }

    // 3, 0
    // 5, 8

    // 0, 3,
    // 3, 3,
    // 5, 8

    //14

//    static class NumMatrixTest {
//
//        int[][] dp = null;
//        public NumMatrixTest(int[][] matrix) {
//           dp = new int[matrix.length+1][matrix[0].length+1];
//           //cal the ranges
//           for (int i = 0; i < matrix.length; i++) {
//
//           }
//
//        }
//
//        public int sumRegion(int row1, int col1, int row2, int col2) {
//
//        }
//    }

    static class NumMatrix {
        private static int[][] dp;
        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            dp = new int[m + 1][n + 1];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int iMin = Math.min(row1, row2);
            int iMax = Math.max(row1, row2);
            int jMin = Math.min(col1, col2);
            int jMax = Math.max(col1, col2);

            return dp[iMax + 1][jMax + 1] - dp[iMax + 1][jMin] - dp[iMin][jMax + 1] + dp[iMin][jMin];
        }
    }
}