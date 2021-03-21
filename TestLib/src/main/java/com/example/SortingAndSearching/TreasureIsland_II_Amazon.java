package com.example.SortingAndSearching;

import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland_II_Amazon {

//    Any block with dangerous rocks or reefs will be marked as ‘D’. You must not enter dangerous blocks. You cannot leave the map area.
//    Other areas ‘O’ are safe to sail in.
//    Output the minimum number of steps to get to any of the treasure.
//            e.g.
//            Input
//[
//        [‘S’, ‘O’, ‘O’, 'S', ‘S’],
//            [‘D’, ‘O’, ‘D’, ‘O’, ‘D’],
//            [‘O’, ‘O’, ‘O’, ‘O’, ‘X’],
//            [‘X’, ‘D’, ‘D’, ‘O’, ‘O’],
//            [‘X', ‘D’, ‘D’, ‘D’, ‘O’],
//            ]
//    Output 3
//    Explanation
//    You can start from (0,0), (0, 3) or (0, 4).
//    The treasure locations are (2, 4) (3, 0) and (4, 0).
//    Here the shortest route is (0, 3), (1, 3), (2, 3), (2, 4).
//    https://aonecode.com/amazon-online-assessment-questions

    public static void main(String[] args) {
        char[][] island = {{'S', 'O','O','S','S'}, {'D','O','D','O','D'}, {'O', 'O', 'O', 'O', 'X'}
                              ,{'X','D','D','O','0'}, {'X','D','D','D','0'}};
        int result = treasureIslandII(island);
        System.out.println(result);
    }

    public static int treasureIslandII(char[][] island) {
        if (island == null || island.length == 0) return 0;
        int steps = 0;
        Queue<Coordinate> queue = new LinkedList<>();
        //queue.add(new Coordinate(0, 0));
        boolean[][] visited = new boolean[island.length][island[0].length];
        for (int i = 0; i < island.length; i++) {
            for (int j =0; j < island[0].length; j++) {
                if(island[i][j] =='S') {
                    queue.add(new Coordinate(i, j));
                    visited[i][j] = true;
                }
            }
        }

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
