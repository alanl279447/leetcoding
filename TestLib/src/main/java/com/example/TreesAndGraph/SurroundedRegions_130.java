package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javafx.util.Pair;

public class SurroundedRegions_130 {
//    X X X X
//    X O O X
//    X X O X
//    X O X X
//    After running your function, the board should be:
//
//    X X X X
//    X X X X
//    X X X X
//    X O X X
//    https://leetcode.com/problems/surrounded-regions/

    //    public static TreeNode root = null;
//    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        char[][] input = { {'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(input);
        for (char[] ip:input)
            System.out.print(ip);
    }

    static Integer ROWS = 0;
    static Integer COLS = 0;
    public static void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        ROWS = board.length;
        COLS = board[0].length;

        List<Pair<Integer, Integer>> borders = new LinkedList<Pair<Integer, Integer>>();
        // Step 1). construct the list of border cells
        for (int r = 0; r < ROWS; ++r) {
            borders.add(new Pair(r, 0));
            borders.add(new Pair(r, COLS - 1));
        }
        for (int c = 0; c < COLS; ++c) {
            borders.add(new Pair(0, c));
            borders.add(new Pair(ROWS - 1, c));
        }

        // Step 2). mark the escaped cells
        for (Pair<Integer, Integer> pair : borders) {
            DFS(board, pair.first, pair.second);
        }

        // Step 3). flip the cells to their correct final states
        for (int r = 0; r < ROWS; ++r) {
            for (int c = 0; c < COLS; ++c) {
                if (board[r][c] == 'O')
                    board[r][c] = 'X';
                if (board[r][c] == 'E')
                    board[r][c] = 'O';
            }
        }
    }

    public static void DFS(char[][] board, int row, int col) {
        if (board[row][col] != 'O')
            return;

        board[row][col] = 'E';
        if (col < COLS - 1)
            DFS(board, row, col + 1);
        if (row < ROWS - 1)
            DFS(board, row + 1, col);
        if (col > 0)
            DFS(board, row, col - 1);
        if (row > 0)
            DFS(board, row - 1, col);
    }

    public static class Pair<U, V> {
        public U first;
        public V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }
}
