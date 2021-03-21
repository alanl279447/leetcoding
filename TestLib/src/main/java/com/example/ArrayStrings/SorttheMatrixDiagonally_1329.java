package com.example.ArrayStrings;

import java.util.HashMap;
import java.util.PriorityQueue;

public class SorttheMatrixDiagonally_1329 {

//    Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
//    Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
//    https://leetcode.com/problems/sort-the-matrix-diagonally/

    public static void main(String[] args) {
        int[][] mat = {{3,3,1,1}, {2,2,1,2}, {1,1,1,2}};
        System.out.println(diagonalSort(mat));
    }

    public static int[][] diagonalSort(int[][] A) {
        int m = A.length, n = A[0].length;
        HashMap<Integer, PriorityQueue<Integer>> d = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                d.putIfAbsent(i - j, new PriorityQueue<>());
                d.get(i - j).add(A[i][j]);
            }
        }
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                A[i][j] = d.get(i - j).poll();
        return A;
    }
}