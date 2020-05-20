package com.example.DynamicProgramming;

public class UniquePathsII_63 {

//    Input:
//            [
//            [0,0,0],
//            [0,1,0],
//            [0,0,0]
//            ]
//    Output: 2
//    Explanation:
//    There is one obstacle in the middle of the 3x3 grid above.
//    There are two ways to reach the bottom-right corner:
//            1. Right -> Right -> Down -> Down
//2. Down -> Down -> Right -> Right
//    https://leetcode.com/problems/unique-paths-ii/

    public static void main(String[] args) {

        int[][] paths = {{0,0,0}, {0,1,0}, {0,0,0}};
        int res = uniquePathsWithObstacles(paths);
        System.out.println(res);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;

        // If the starting cell has an obstacle, then simply return as there would be
        // no paths to the destination.
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // Number of ways of reaching the starting cell = 1.
        obstacleGrid[0][0] = 1;

        // Filling the values for the first column
        for (int i = 1; i < R; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }

        // Filling the values for the first row
        for (int i = 1; i < C; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }

        // Starting from cell(1,1) fill up the values
        // No. of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
        // i.e. From above and left.
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        // Return value stored in rightmost bottommost cell. That is the destination.
        return obstacleGrid[R - 1][C - 1];
    }



//    public static int uniquePathsWithObstaclesOld(int[][] obstacleGrid) {
//
//        int R = obstacleGrid.length;
//        int C = obstacleGrid[0].length;
//
//        // If the starting cell has an obstacle, then simply return as there would be
//        // no paths to the destination.
//        if (obstacleGrid[0][0] == 1) {
//            return 0;
//        }
//
//        // Number of ways of reaching the starting cell = 1.
//        obstacleGrid[0][0] = 1;
//
//        // Filling the values for the first column
//        for (int i = 1; i < R; i++) {
//            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
//        }
//
//        // Filling the values for the first row
//        for (int i = 1; i < C; i++) {
//            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
//        }
//
//        // Starting from cell(1,1) fill up the values
//        // No. of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
//        // i.e. From above and left.
//        for (int i = 1; i < R; i++) {
//            for (int j = 1; j < C; j++) {
//                if (obstacleGrid[i][j] == 0) {
//                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
//                } else {
//                    obstacleGrid[i][j] = 0;
//                }
//            }
//        }
//
//        // Return value stored in rightmost bottommost cell. That is the destination.
//        return obstacleGrid[R - 1][C - 1];
//    }

}
