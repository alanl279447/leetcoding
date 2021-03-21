package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {
//    Input:
//            [
//            [ 1, 2, 3 ],
//            [ 4, 5, 6 ],
//            [ 7, 8, 9 ]
//            ]
//    Output: [1,2,3,6,9,8,7,4,5]
//
//    Input:
//            [
//            [1, 2, 3, 4],
//            [5, 6, 7, 8],
//            [9,10,11,12]
//            ]
//    Output: [1,2,3,4,8,12,11,10,9,5,6,7]
//
//    https://leetcode.com/problems/spiral-matrix/


    public static void main(String[] args) {
        int[][] board = {{0,1,0}, {0,0,1}, {1,1,1}, {0,0,0}};
        List<Integer> result = spiralOrder(board);
        for(Integer res: result) {
            System.out.println(res);
        }
    }


    //row = 0, col 0 to cols-1
    //col = cols-1 row 0+1 to rows-1
    //row = rows-1 col cols-1-1 to 0
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0) {
            return res;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }
        return res;
    }

}
