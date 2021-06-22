package com.example.DynamicProgramming;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SwiminRisingWater_778 {
//    https://leetcode.com/problems/swim-in-rising-water/
//    Input: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
//    Output: 16
//    Explanation:
//            0  1  2  3  4
//            24 23 22 21  5
//            12 13 14 15 16
//            11 17 18 19 20
//            10  9  8  7  6
//
//    The final route is marked in bold.
//    We need to wait until time 16 so that (0, 0) and (4, 4) are connected.

    //0(logN*N^2)
   public static void main(String[] args) {
        //boolean res = canIWin(10, 11);
        int[][] input = {{0,2},{1,3}};
        int result = swimInWater(input);
        System.out.println(result);
    }

    public static int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[n][n];
        int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        visited[0][0] = true;
        pq.offer(new int[]{0, 0, grid[0][0]});
        while(!pq.isEmpty()){
            int[] info = pq.poll();
            int i = info[0], j = info[1], max = info[2];
            for(int[] dir : dirs){
                int newI = dir[0] + i, newJ = dir[1] + j;
                if(newI < 0 || newI >= n || newJ < 0 || newJ >= n)  continue;
                if(!visited[newI][newJ]){
                    visited[newI][newJ] = true;
                    int newmax = Math.max(max, grid[newI][newJ]);
                    if(newI == n - 1 && newJ == n - 1)  return newmax;
                    pq.offer(new int[]{newI, newJ, newmax});
                }
            }
        }
        return 0;
    }
}