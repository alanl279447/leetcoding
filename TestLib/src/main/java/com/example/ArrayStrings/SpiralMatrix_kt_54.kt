package com.example.ArrayStrings;

import java.util.*
import kotlin.collections.ArrayList

public class SpiralMatrix_kt_54 {
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


    fun main(args: Array<String>) {
        var result = spiralOrder(arrayOf(intArrayOf(0,1,0), intArrayOf(0,0,1), intArrayOf(1,1,1), intArrayOf(0,0,0)));
        for(res in result) {
            System.out.println(res);
        }
    }

    //row = 0, col 0 to cols-1
    //col = cols-1 row 0+1 to rows-1
    //row = rows-1 col cols-1-1 to 0
     fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val res: MutableList<Int> = ArrayList()
        if (matrix.size == 0) {
            return res
        }

        var rowBegin = 0
        var rowEnd = matrix.size - 1
        var colBegin = 0
        var colEnd: Int = matrix[0].size - 1

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (j in colBegin..colEnd) {
                res.add(matrix[rowBegin][j])
            }
            rowBegin++

            // Traverse Down
            for (j in rowBegin..rowEnd) {
                res.add(matrix[j][colEnd])
            }
            colEnd--
            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (j in colEnd downTo colBegin) {
                    res.add(matrix[rowEnd][j])
                }
            }
            rowEnd--
            if (colBegin <= colEnd) {
                // Traver Up
                for (j in rowEnd downTo rowBegin) {
                    res.add(matrix[j][colBegin])
                }
            }
            colBegin++
        }
        return res

        }

    }