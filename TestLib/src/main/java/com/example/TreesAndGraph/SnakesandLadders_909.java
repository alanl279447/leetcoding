package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SnakesandLadders_909 {
//    Input: [
//            [-1,-1,-1,-1,-1,-1],
//            [-1,-1,-1,-1,-1,-1],
//            [-1,-1,-1,-1,-1,-1],
//            [-1,35,-1,-1,13,-1],
//            [-1,-1,-1,-1,-1,-1],
//            [-1,15,-1,-1,-1,-1]]
//    Output: 4
//    Explanation:
//    At the beginning, you start at square 1 [at row 5, column 0].
//    You decide to move to square 2, and must take the ladder to square 15.
//    You then decide to move to square 17 (row 3, column 5), and must take the snake to square 13.
//    You then decide to move to square 14, and must take the ladder to square 35.
//    You then decide to move to square 36, ending the game.
//    It can be shown that you need at least 4 moves to reach the N*N-th square, so the answer is 4.
//
//    https://leetcode.com/problems/snakes-and-ladders/

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[][] input = {{-1,-1,-1,-1,-1,-1}, {-1,-1,-1,-1,-1,-1}, {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
       System.out.println(snakesAndLaddersNew(input));
    }

    public static int snakesAndLaddersNew(int[][] board) {
        int length = board.length;
        boolean[] visited = new boolean[length*length +1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        for (int move = 0; !queue.isEmpty(); move++) {
            for (int size = queue.size(); size > 0; size--) {
                int entry = queue.poll();
                if (visited[entry]) {
                    continue;
                }
                visited[entry] = true;
                if (entry == length*length) return move;
                for (int i=1; i <= 6 && entry+i<=length*length; i++) {
                    int next = entry+i;
                    int value = getBoardValue(board, next);
                    if (value > 0) {
                        next = value;
                    }
                    if (!visited[next]) queue.offer(next);
                }
            }
        }
        return -1;
    }

    public static int getBoardValueNew(int[][] board, int next) {
        int length = board.length;
        int oldRow = (next -1)/length;
        int oldColumn = (next-1)%length;

        int newRow = length-1-oldRow;
        int newColumn = newRow%2==0 ?oldColumn:length-1-oldColumn;
        return board[newRow][newColumn];
    }

    public static int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        boolean[] visited = new boolean[n * n + 1];
        for (int move = 0; !queue.isEmpty(); move++) {
            for (int size = queue.size(); size > 0; size--) {
                int num = queue.poll();
                if (visited[num]) continue;
                visited[num] = true;
                if (num == n * n) return move;
                for (int i = 1; i <= 6 && num + i <= n * n; i++) {
                    int next = num + i;
                    int value = getBoardValue(board, next);
                    if (value > 0) next = value;
                    if (!visited[next]) queue.offer(next);
                }
            }
        }
        return -1;
    }

    private static int getBoardValue(int[][] board, int num) {
        int n = board.length;
        int oldRow = (num - 1) / n;
        int row = n-1 -oldRow;
        int oldCol = (num-1) % n;
        int col = oldRow % 2 == 0 ? oldCol : n - 1 - oldCol;

        return board[row][col];
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
