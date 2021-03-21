package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow_417 {

//    Given the following 5x5 matrix:
//    Pacific ~   ~   ~   ~   ~
//            ~  1   2   2   3  (5) *
//            ~  3   2   3  (4) (4) *
//            ~  2   4  (5)  3   1  *
//            ~ (6) (7)  1   4   5  *
//            ~ (5)  1   1   2   4  *
//            *   *   *   *   * Atlantic
//    Return:[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
//    https://leetcode.com/problems/pacific-atlantic-water-flow/
//    time complexity O(mn)   // O(4mn)

    public static void main(String[] args) {
        int[][] matrix = {{1,2,2,3,5}, {3,2,3,4,4}, {2,4,5,3,1}, {6,7,1,4,5}, {5,1,1,2,4}};
        List<List<Integer>> result = pacificAtlantic(matrix);
        for (List<Integer> res: result) {
            System.out.println(res.toString());
        }
    }

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new LinkedList<>();
        if (matrix == null || matrix.length==0 || matrix[0].length == 0) {
            return result;
        }

        int n = matrix.length, m = matrix[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        for (int i =0; i <n; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, m-1);
        }
        for (int i =0; i <m; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, n-1, i);
        }

        for (int i =0; i <n; i++) {
            for (int j =0; j <m; j++) {
              if (pacific[i][j] && atlantic[i][j]) {
                  result.add(new LinkedList());
                  result.get(result.size()-1).add(i);
                  result.get(result.size()-1).add(j);
              }
            }
        }
        return result;
    }

    static int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public static void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y) {
        int n = matrix.length, m = matrix[0].length;
        if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < height) {
            return;
        }
        visited[x][y] = true;
        for (int[] dir: dirs) {
            dfs(matrix, visited, matrix[x][y], x+dir[0], y+dir[1]);
        }
    }
}