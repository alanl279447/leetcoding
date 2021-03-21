package com.example.TreesAndGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
//Input: grid = [[1,0,0],[0,0,0],[0,0,0]]
//        Output: 4
//        Explanation: The cell (2, 2) is as far as possible from all the land with distance 4.
//        https://leetcode.com/problems/as-far-from-land-as-possible/

public class AsFarfromLandasPossible_1162 {

    public static void main(String[] args) {
        int[][] grid = {{1,0,0}, {0,0,0}, {0,0,0}};
        System.out.println(maxDistance(grid));
    }

    //add all 1's to the BFS queue
    //BFS to go over all the neighbors which are 0's
    // increment the level after traversing all the 1's
    static int[][] directions = new int[][] {{-1, 0},{1,0},{0,-1},{0,1}};
    public static int maxDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)return -1;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i = 0 ; i < grid.length ; i++) {
            for(int j = 0 ; j < grid[0].length ; j++) {
                if(grid[i][j] == 1) {
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        int level = -1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0 ; i < size ; i++) {
                int[] start = queue.poll();
                int x = start[0];
                int y = start[1];
                for(int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length
                            && !visited[newX][newY] && grid[newX][newY] == 0) {
                        visited[newX][newY] = true;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
            level++;
        }
        return level <= 0 ? -1 : level;
    }
}