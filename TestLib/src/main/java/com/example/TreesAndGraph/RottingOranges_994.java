package com.example.TreesAndGraph;

import java.util.ArrayDeque;
import java.util.Deque;
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
        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;
        //Put the position of all rotten oranges in queue
        //count the number of fresh oranges
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i , j});
                }
                else if(grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }
        //if count of fresh oranges is zero --> return 0
        if(count_fresh == 0) return 0;
        int count = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        //bfs starting from initially rotten oranges
        while(!queue.isEmpty()) {
            ++count;
            int size = queue.size();
            for(int i = 0 ; i < size ; i++) {
                int[] point = queue.poll();
                for(int dir[] : dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    //if x or y is out of bound
                    //or the orange at (x , y) is already rotten
                    //or the cell at (x , y) is empty
                    //we do nothing
                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) continue;
                    //mark the orange at (x , y) as rotten
                    grid[x][y] = 2;
                    //put the new rotten orange at (x , y) in queue
                    queue.offer(new int[]{x , y});
                    //decrease the count of fresh oranges by 1
                    count_fresh--;
                }
            }
        }
        return count_fresh == 0 ? count-1 : -1;
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
