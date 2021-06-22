package com.example.DynamicProgramming;

import java.util.Arrays;

public class DungeonGame_174 {
//    https://leetcode.com/problems/dungeon-game/
//    Input: dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
//    Output: 7
//    Explanation: The initial health of the knight must be at least 7 if he follows the optimal path: RIGHT-> RIGHT -> DOWN -> DOWN.
    public static void main(String[] args) {
        //boolean res = canIWin(10, 11);
        int[][] input = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int result = calculateMinimumHP(input);
        System.out.println(result);
    }

    static int inf = Integer.MAX_VALUE;
    static int[][] dp;
    static int rows, cols;
    public static int calculateMinimumHP(int[][] dungeon) {
        rows = dungeon.length;
        cols = dungeon[0].length;
        dp = new int[rows][cols];
        for (int[] arr : dp) {
            Arrays.fill(arr, inf);
        }
        int currCell, rightHealth, downHealth, nextHealth, minHealth;
        for (int row = rows - 1; row >= 0; --row) {
            for (int col = cols - 1; col >= 0; --col) {
                currCell = dungeon[row][col];

                rightHealth = getMinHealth(currCell, row, col + 1);
                downHealth = getMinHealth(currCell, row + 1, col);
                nextHealth = Math.min(rightHealth, downHealth);     //nextHealth - prev position either top or left

                if (nextHealth != inf) {
                    minHealth = nextHealth;
                } else {
//                     If the current cell is of magic orb, then 1 health point would suffice.
//                    If the current cell is of daemon,
//                    then the knight should possess one health point plus the damage points that would be caused by the daemon.
                    minHealth = currCell >= 0 ? 1 : 1 - currCell;
                }
                dp[row][col] = minHealth;
            }
        }
        return dp[0][0];
    }

    public static int getMinHealth(int currCell, int nextRow, int nextCol) {
        if (nextRow >= rows || nextCol >= cols)
            return inf;
        int nextCell = dp[nextRow][nextCol];
        // hero needs at least 1 point to survive
        return Math.max(1, nextCell - currCell);
    }
}