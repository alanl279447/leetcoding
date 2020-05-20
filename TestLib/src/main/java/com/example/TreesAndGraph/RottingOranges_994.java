package com.example.TreesAndGraph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

//Input: [[2,1,1],[1,1,0],[0,1,1]]
//        Output: 4
//
//        Input: [[2,1,1],[0,1,1],[1,0,1]]
//        Output: -1
//        Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten,
//        because rotting only happens 4-directionally.
//
//        https://leetcode.com/problems/rotting-oranges/

public class RottingOranges_994 {

    public static void main(String[] args) {
        int [][] input = {{2,1,1}, {1,1,0}, {0,1,1}};
        System.out.print(orangesRotting(input));
    }

    public static int orangesRotting(int[][] grid) {
        int R = grid.length; int C = grid[0].length;
        //boolean[][] visited = new boolean[R][C];
        Queue<O> q = new ArrayDeque<>();
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(grid[i][j] == 2){
                    q.add(new O(i, j, 0));
                }
            }
        }

        int res = 0;

        while(!q.isEmpty()){
            O cur = q.poll();

            res = Math.max(res, cur.layer);

            for(int k = 0; k < x.length; k++){
                int ro = cur.x + x[k];
                int co = cur.y + y[k];

                if(inside(grid, ro, co) && grid[ro][co] == 1) {
                    q.offer(new O(ro, co,  cur.layer + 1));
                    grid[ro][co] = 2;
                }
            }
        }

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return res;
    }

    public static class O {
        int x ; int y ;
        int layer;
        public O(int x, int y, int layer){
            this.x = x; this.y = y; this.layer = layer;
        }
    }

//    static int[] x = {0,0,-1,1};
//    static int[] y = {-1,1,0,0};

    static int[] x = {-1,0,1,0};
    static int[] y = {0,-1,0,1};

    public static boolean inside(int[][] grid, int i , int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)return  false;
        return true;
    }
}
