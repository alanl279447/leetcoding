package com.example.ArrayStrings;

//https://leetcode.com/problems/valid-tic-tac-toe-state/
//Example 1:
//Input: board = ["O  ", "   ", "   "]
//Output: false
//Explanation: The first player always plays "X".
//
//Example 2:
//Input: board = ["XOX", " X ", "   "]
//Output: false
//Explanation: Players take turns making moves.

class ValidTicTacToeState_794 {

    public static void main(String[] args) {
        String[] input = {"O  ", "   ", "   "};
        boolean result = validTicTacToe(input);
        System.out.print(result);
    }

    public static boolean validTicTacToe(String[] board) {
        int turns = 0;
        boolean xwin = false;
        boolean owin = false;
        int[] rows = new int[3];
        int[] cols = new int[3];
        int diag = 0;
        int antidiag = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X') {
                    turns++;
                    rows[i]++;
                    cols[j]++;
                    if (i == j) diag++;
                    if (i + j == 2) antidiag++;
                } else if (board[i].charAt(j) == 'O') {
                    turns--;
                    rows[i]--;
                    cols[j]--;
                    if (i == j) diag--;
                    if (i + j == 2) antidiag--;
                }
            }
        }

        xwin = rows[0] == 3 || rows[1] == 3 || rows[2] == 3 ||
                cols[0] == 3 || cols[1] == 3 || cols[2] == 3 ||
                diag == 3 || antidiag == 3;
        owin = rows[0] == -3 || rows[1] == -3 || rows[2] == -3 ||
                cols[0] == -3 || cols[1] == -3 || cols[2] == -3 ||
                diag == -3 || antidiag == -3;

        if ((xwin && turns != 1) || (owin && turns != 0)) return false;
        return turns == 1 || turns == 0;
    }
}