package com.example.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathwithMaximumGold_1219 {
//    Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
//    Output: 24
//    Explanation:
//            [[0,6,0],
//            [5,8,7],
//            [0,9,0]]
//    Path to get the maximum gold, 9 -> 8 -> 7.
//    https://leetcode.com/problems/path-with-maximum-gold/

    public static void main(String[] args) {
        int[][] grid = {{0,6,0}, {5,8,7}, {0,9,0}};
        int result = getMaximumGold(grid);
       System.out.println(result);
    }

    public static int getMaximumGold(int[][] grid) {
      if (grid == null) return 0;
      int row = grid.length;
      int column = grid[0].length;
      boolean[][] visited = new boolean[row][column];
      int maxGold = 0;

      for (int i=0; i < row; i++) {
          for (int j =0; j < column; j++) {
              if (grid[i][j] != 0) {
                  int currentPathmaxGold = dfs(grid, i, j, visited);
                  maxGold = Math.max(maxGold, currentPathmaxGold);
              }
          }
      }
      return maxGold;
    }

    public static int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >=grid.length || j >= grid[0].length || grid[i][j]==0 || visited[i][j] == true) {
            return 0;
        }
        visited[i][j] = true;
        int left = dfs(grid, i-1, j, visited);
        int right = dfs(grid, i+1, j, visited);
        int top = dfs(grid, i, j-1, visited);
        int down = dfs(grid, i, j+1, visited);
        visited[i][j] = false;
        return Math.max(left, Math.max(right, Math.max(top, down))) + grid[i][j];
    }
}
