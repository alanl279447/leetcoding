package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javafx.util.Pair;

//       Input: [[1, 1], [1, 0]]
//        Output: 4
//        Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
//        https://leetcode.com/problems/making-a-large-island/
//        https://www.youtube.com/watch?v=_426VVOB8Vo
//       time complexity 0(n^2)

public class MaxAreaofIsland_695 {
    public static void main(String[] args) {
        int[][] grid = {{1,1}, {1,0}};
//        System.out.print(largestIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        int max = 0;
        for (int i =0; i< rows; i++) {
            for (int j = 0; j < cols; j++) {
              if (grid[i][j] == 1) {
                  int len = dfs(grid, i, j);
                  max = Math.max(max, len);
              }
            }
        }
        return max;
    }

    static int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public static int dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1) {
            return 0;
        }
        grid[row][col] = -1;
        int len = 1;
        for (int[] dir: dirs) {
            len += dfs(grid, row+dir[0], col+dir[1]);
        }
        return len;
    }
}