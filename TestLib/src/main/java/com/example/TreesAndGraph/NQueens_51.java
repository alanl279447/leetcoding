package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class NQueens_51 {
//    https://leetcode.com/problems/n-queens/
//    Input: n = 4
//    Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//    Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
    //time complexity 0(n!)
    public static void main(String[] args) {
        List<List<String>> result = solveNQueens(4);
        for (List<String> res: result)
         System.out.println(res.toString());
    }
          //j
    //   0 1 2 3
    // 0 0 1 2 3    0  1  2  3
//i // 1 1 2 3 4   -1  0  1  2
    // 2 2 3 4 5   -2 -1  0  1
    // 3 3 4 5 6   -3 -2 -1  0
    static List<List<String>> res = new ArrayList<>();
    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        placeQueen(board, 0, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>());
        return res;
    }

    public static void placeQueen(char[][] board, int i, Set<Integer> diagonal, Set<Integer> antidiagonal, Set<Integer> vertical) {
        if (i == board.length) {
            res.add(compute(board));
            return;
        }
         for (int j = 0; j < board[0].length; j++) {
             if (!diagonal.contains(i+j) && !antidiagonal.contains(j-i) && !vertical.contains(j)) {
                 board[i][j] = 'Q';
                 diagonal.add(i+j);
                 antidiagonal.add(j-i);
                 vertical.add(j);
                 placeQueen(board, i+1, diagonal, antidiagonal, vertical);
                 board[i][j] = '.';
                 diagonal.remove(i+j);
                 antidiagonal.remove(j-i);
                 vertical.remove(j);
             }
        }
    }

    public static List<String> compute(char[][] board) {
        List<String> result = new ArrayList<>();
        for (int i =0; i < board.length; i++) {
            result.add(new String(board[i]));
        }
        return result;
    }
}