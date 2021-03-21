package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
        char[][] input = { {'1','1','0','0','0'},{'1','1','0','0','0'},
                {'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.print(numIslandsdfs(input));
    }

    //queue & dirs array to traverse the 4 directions
    //time complexity o(mn)
    //space complexity 0(min(mn))
    public static int numIslandsbfs(char[][] grid) {
        int row  =  grid.length;
        int col = grid[0].length;
        int count=0;
        LinkedList<int[]> queue = new LinkedList<>();
        for (int r = 0; r < row; r++) {
            for (int c =0; c < col; c++) {
                if (grid[r][c]=='1') {
                    queue.add(new int[]{r,c});
                    bfs(grid, r,c, queue);
                    count++;
                }
            }
        }
        return count;
    }

    public static int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public static void bfs(char[][] grid, int r, int c, LinkedList<int[]> queue) {
        while(!queue.isEmpty()) {
            int[] currentElement = queue.poll();
            for (int[] dir: dirs) {
               int newRow  = dir[0] + currentElement[0];
               int newCol = dir[1] + currentElement[1];
               if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length || grid[newRow][newCol] =='0')
                   continue;
               queue.offer(new int[]{newRow, newCol});
               grid[newRow][newCol]='0';
            }
        }
    }


    //time complexity 0(mn)
    //space complexity 0(mn)
    public static int numIslandsdfs(char[][] grid) {
        int numberOfIslands = 0;
        if (grid == null || grid.length == 0) return 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    numberOfIslands += dfs(grid, i, j);
                }
            }
        }
        return numberOfIslands;
    }

    public static int dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0')
            return 0;
        grid[i][j] = '0';
        dfs(grid, i +1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
        return 1;
    }
}
