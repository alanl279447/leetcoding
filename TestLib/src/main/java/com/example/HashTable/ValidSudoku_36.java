package com.example.HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ValidSudoku_36 {
//    Input:[
//            ["5","3",".",".","7",".",".",".","."],
//            ["6",".",".","1","9","5",".",".","."],
//            [".","9","8",".",".",".",".","6","."],
//            ["8",".",".",".","6",".",".",".","3"],
//            ["4",".",".","8",".","3",".",".","1"],
//            ["7",".",".",".","2",".",".",".","6"],
//            [".","6",".",".",".",".","2","8","."],
//            [".",".",".","4","1","9",".",".","5"],
//            [".",".",".",".","8",".",".","7","9"]
//            ]
//    Output: true
//    https://leetcode.com/problems/valid-sudoku/

    public static void main(String[] args) {
        char[][] input = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}};
        boolean res = isValidSudoku(input);
        System.out.println(res);
    }

    // Set<String> set
    // row   item 4 at row i      (4)i
    // column item 4 at column i  i(4)
    // item 4 in box i           i/3(4)j/3
    public static boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i=0; i< board.length; i++) {
            for (int j=0;j< board[0].length;j++) {
                if (board[i][j] != '.') {
                    if (!seen.add("(" + board[i][j] + ")" + i) ||
                            !seen.add(j + "(" + board[i][j] + ")") ||
                            !seen.add(i/3 + "(" + board[i][j] + ")" +j/3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
