package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import javafx.scene.layout.Priority;

public class PathWithMaximumMinimumValue_work_1102 {
//    Input: [[5,4,5],[1,2,6],[7,4,6]]
//    Output: 4
//    Explanation:
//    The path with the maximum score is highlighted in yellow.
//    https://leetcode.com/problems/path-with-maximum-minimum-value/
//   time complexity mn*log(mn)

    public static void main(String[] args) {
        int[][] A = {{5,4,5}, {1,2,6}, {7,4,6}};
        int result = maximumMinimumPath(A);
        System.out.println(result);
    }
    static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static int maximumMinimumPath(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        boolean[][] visited = new boolean[n][m];
        // in the BFS approach, for each step, we are interested in getting the maximum min that we have seen so far,
        // thus we reverse the ordering in the pq
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);

        pq.offer(new int[]{0, 0, A[0][0]});

        // BFS
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int row = cell[0];
            int col = cell[1];

            if (row == n - 1 && col == m - 1) {
                return cell[2];
            }

            for (int[] dir : directions) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m || visited[nextRow][nextCol]) continue;

                // we are keeping track of the min element that we have seen until now
                pq.offer(new int[]{nextRow, nextCol, Math.min(cell[2], A[nextRow][nextCol])});
                visited[nextRow][nextCol] = true;
            }
        }
        return -1;
    }
}