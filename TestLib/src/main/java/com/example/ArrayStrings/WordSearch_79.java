package com.example.ArrayStrings;

//board =
//        [
//        ['A','B','C','E'],
//        ['S','F','C','S'],
//        ['A','D','E','E']
//        ]
//        Given word = "ABCCED", return true.
//        Given word = "SEE", return true.
//        Given word = "ABCB", return false.
//        https://leetcode.com/problems/word-search/

public class WordSearch_79 {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        System.out.println("Start main " + exist(board, "ABCCEDE"));
        System.out.println("Start main " + exist(board, "ABC"));
    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                if (exists(board, i, j, word, 0))
                    return true;
            }
        return false;
    }

    public static boolean exists(char[][] board, int row, int column, String word, int index) {
        if (index == word.length()) return true;
        if (row < 0 || row > board.length-1 || column < 0 || column > board[0].length -1 ||
            board[row][column] != word.charAt(index)) {
            return false;
        }
        board[row][column] = '*';
        boolean result = exists(board, row+1, column, word, index+1) ||
                exists(board, row-1, column, word, index+1) ||
                exists(board, row, column-1, word, index+1) ||
                exists(board, row, column+1, word, index+1);
        board[row][column] = word.charAt(index);
        return result;
    }


















//    private static boolean exist(char[][] board, int i, int j, String word, int ind) {
//        if (ind == word.length()) return true;
//        if (i > board.length - 1 || i < 0 || j < 0 || j > board[0].length - 1 || board[i][j] != word.charAt(ind))
//            return false;
//        board[i][j] = '*';
//        boolean result = exist(board, i - 1, j, word, ind + 1) ||
//                exist(board, i, j - 1, word, ind + 1) ||
//                exist(board, i, j + 1, word, ind + 1) ||
//                exist(board, i + 1, j, word, ind + 1);
//        board[i][j] = word.charAt(ind);
//        return result;
//    }
}
