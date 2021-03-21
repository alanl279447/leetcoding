package com.example.ArrayStrings;

public class NumberofClosedIslands_1254 {
//    Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
//    Output: 2
//    Explanation:
//    Islands in gray are closed because they are completely surrounded by water (group of 1s).
//    https://leetcode.com/problems/number-of-closed-islands/

    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        System.out.println(closedIsland(grid));
    }

    public static int closedIsland(int[][] grid) {
       for(int i =0;i<grid.length;i++) {
           for(int j=0; j<grid[0].length;j++) {
               if (i==0|| j==0 || i==grid.length-1 || j==grid[i].length-1) {
                   fillFlood(grid, i, j);
               }
           }
       }
       int result=0;
        for(int i =0;i<grid.length;i++) {
            for (int j = 0; j < grid[0].length; j++) {
              if (grid[i][j]==0) {
                  result++;
                  fillFlood(grid, i, j);
              }
            }
        }
        return result;
    }

    static int[][] direction = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public static void fillFlood(int[][] grid, int i,int j) {
        if(i < 0||j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j]==1) return;
        grid[i][j]=1;
        for (int d=0;d<direction.length;d++) {
            fillFlood(grid, direction[d][0], direction[d][1]);
        }
    }
}