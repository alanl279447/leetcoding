package com.example.TreesAndGraph;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class NumIsIands {

//    Input:
//11000
//11000
//00100
//00011
//
//    Output: 3
//    https://leetcode.com/problems/number-of-islands/solution/
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        char[][] input = { {'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.print(numIslands(input));
    }

    public static int numIslands(char[][] grid) {
        int numberOfIslands = 0;
        if (grid == null || grid.length == 0) return 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    numberOfIslands += bfs(grid, i, j);
                }
            }
        }
        return numberOfIslands;
    }

    public static int bfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0')
            return 0;
        grid[i][j] = '0';
        bfs(grid, i +1, j);
        bfs(grid, i-1, j);
        bfs(grid, i, j-1);
        bfs(grid, i, j+1);
        return 1;
    }
}
