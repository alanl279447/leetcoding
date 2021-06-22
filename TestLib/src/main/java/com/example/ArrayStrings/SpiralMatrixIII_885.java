package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixIII_885 {
//    Input: R = 5, C = 6, r0 = 1, c0 = 4
//    Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[
//            3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],
//            [2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
//    https://leetcode.com/problems/spiral-matrix-iii/
//    https://www.youtube.com/watch?v=0qep3f9cqVs

    public static void main(String[] args) {
        int[][] result = spiralMatrixIII(5,6,1,4);
        for(int[] res: result) {
            System.out.println(res.toString());
        }
    }

    public static int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
       int [][] matrix = new int[R*C][2];
       int len = 0;
       int i =0;
       matrix[i++] = new int[]{r0, c0};
       int[] directions = {0,1, 0, -1, 0};
       int dir = 0;
       while (i < R*C) {
         if (dir ==0 || dir == 2) len++;    // 0 - left,  2 - right increment len to cover additional column.
         for (int k=0; k < len; k++) {
             r0 += directions[dir];
             c0 += directions[dir+1];

             if (r0 >=0 && r0 < R && c0>=0 && c0 < C) {
                 matrix[i++] = new int[] {r0, c0};
             }
         }
          dir = ++dir%4;
       }
       return matrix;
    }
}