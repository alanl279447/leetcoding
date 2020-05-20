package com.example.SortingAndSearching;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreasureIsland_Amazon {

//    Input:
//            [['O', 'O', 'O', 'O'],
//            ['D', 'O', 'D', 'O'],
//            ['O', 'O', 'O', 'O'],
//            ['X', 'D', 'D', 'O']]
//
//    Output: 5
//    Explanation: Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps.
//    https://leetcode.com/discuss/interview-question/347457

//    public static TreeNode root = null;
    public static int treasureIsland(char[][] island) {
        if (island == null || island.length == 0) return 0;

        int steps = 0;
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(0, 0));
        boolean[][] visited = new boolean[island.length][island[0].length];
        visited[0][0] = true;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // bfs
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinate coordinate = queue.poll();
                int x = coordinate.x;
                int y = coordinate.y;
                if (island[x][y] == 'X') return steps;

                for (int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX >= 0 && newX < island.length && newY >= 0 && newY < island[0].length &&
                            island[newX][newY] != 'D' && !visited[newX][newY]) {
                        queue.add(new Coordinate(newX, newY));
                        visited[newX][newY] = true;
                    }
                }
            }
            steps++;
        }
        return 0;
    }

    static class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
