package com.example.ArrayStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/sudoku-solver/
//        Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
//        Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
//        Explanation: The input board is shown above and the only valid solution is shown below:


public class SudokuSolver_37 {
    public static void main(String[] args) {
//        System.out.println(areSentencesSimilar(sentence1, sentence2, similarPairs));
    }

    public void solveSudoku(char[][] board) {
        if (board == null || board.length ==0) return;
        solve(board, 0,0);
    }

    public void solve(char[][] board, int r, int c) {
        if (r == board.length) {
            return;
        }
        int nr = 0, nc = 0;
        if ( c == board[0].length-1) {
            nr += 1;
            nc = 0;
        } else {
            nr = r;
            nc += 1;
        }

        if (board[r][c] != '.') {
            solve(board, nr, nc);
        } else {
            for (char i= '1'; i<= '9'; i++) {
                if (isValid(board, r, c, i)) {
                    board[r][c] = '1';
                    solve(board, nr, nc);
                    board[r][c] = '.';
                }
            }
        }
    }

    public static boolean isValid(char[][] board, int r, int c, char ch) {
        for (int j = 0; j < c; j++) {
            if (board[r][j] == ch) return false;
        }

        for (int i = 0; i < r; i++) {
            if (board[i][c] == ch) return false;
        }

        int xStart = r/3 * 3;
        int yStart = c/3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[xStart+i][yStart+j] == ch) return false;
            }
        }
        return true;
    }
}