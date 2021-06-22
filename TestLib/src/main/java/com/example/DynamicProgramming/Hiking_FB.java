package com.example.DynamicProgramming;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
//        900 500 300
//        700 500 300
//        0 100 200
//
//        Output: 300 (0 -> 100 -> 200 -> 300)
//
//        Top-down view of hiking area
//        Each number => height of that cell
//        Goal: find the height of the highest accessible cell
//        A cell is accessible if:
//        Height = 0; or
//        Adjacent to another accessible cell, height difference <= 100
//        '''

public class Hiking_FB {
    //0(logN*N^2)
   public static void main(String[] args) {
        //boolean res = canIWin(10, 11);
        int[][] input = {{0,2},{1,3}};
        int result = swimInWater(input);
        System.out.println(result);
    }

    public static int swimInWater(int[][] arr) {
        if (arr == null || arr.length == 0) return 0;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int max = 0;
        int[][] DIRECTIONS = new int[][]{
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0];
            int j = cell[1];
            max = Math.max(max, arr[i][j]);
            for (int[] d : DIRECTIONS) {
                int newI = i + d[0];
                int newJ = j + d[1];
                if (newI >= 0
                        && newJ >= 0
                        && newI < arr.length
                        && newJ < arr[newI].length
                        && !visited[newI][newJ]
                        && Math.abs(arr[i][j] - arr[newI][newJ]) <= 100) {
                    visited[newI][newJ] = true;
                    queue.add(new int[]{newI, newJ});
                }
            }
        }
        return max;
    }
}