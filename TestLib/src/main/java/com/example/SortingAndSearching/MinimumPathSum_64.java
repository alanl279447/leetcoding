package com.example.SortingAndSearching;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumPathSum_64 {

//    Input:
//            [
//            [1,3,1],
//            [1,5,1],
//            [4,2,1]
//            ]
//    Output: 7
//    Explanation: Because the path 1→3→1→1→1 minimizes the sum.
//    https://leetcode.com/problems/minimum-path-sum/

    public static void main(String[] args) {
        int[][] input = {{1,3,1}, {1,5,1}, {4,2,1}};
        int result = minPathSum(input);
        System.out.println(result);
    }

    //time complexity 0(mn)
    public static int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;

        for (int i=1; i<column;i++) {
            grid[0][i]+=grid[0][i-1];
        }

        for (int j=1;j<row;j++) {
            grid[j][0] +=grid[j-1][0];
        }

        for (int  i=1; i<row;i++) {
            for (int j=1; j<column;j++) {
              grid[i][j]+=Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[row-1][column-1];
    }

    //   time complexity mn*log(mn)
    public static int minPathSumPrac(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a1[2] - a2[2]);
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        pq.offer(new int[] {0, 0, grid[0][0]});
        visited[0][0] = true;
        int dirs[][] = new int[][] {{1, 0}, {0, 1}};
        while (!pq.isEmpty())   {
            int[] poll = pq.poll();
            for (int d[] : dirs)    {
                int nr = poll[0] + d[0];
                int nc = poll[1] + d[1];
                if (isValid(nr, nc, visited))    {
                    grid[nr][nc] = grid[nr][nc] + grid[poll[0]][poll[1]];
                    pq.offer(new int[] {nr, nc, grid[nr][nc]});
                    visited[nr][nc] = true;
                    if (nr == grid.length - 1 && nc == grid[0].length - 1)
                        return grid[nr][nc];
                }
            }
        }

        return grid[0][0];
    }

    private static boolean isValid(int nr, int nc, boolean[][] visited)   {
        return !(nr >= visited.length || nc >= visited[0].length || visited[nr][nc]);
    }

}
