package com.example.DesignQuestions;

public class DesignTicTacToe_348 {
    //    Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.
//
//            TicTacToe toe = new TicTacToe(3);
//
//toe.move(0, 0, 1); -> Returns 0 (no one wins)
//            |X| | |
//            | | | |    // Player 1 makes a move at (0, 0).
//            | | | |
//
//            toe.move(0, 2, 2); -> Returns 0 (no one wins)
//            |X| |O|
//            | | | |    // Player 2 makes a move at (0, 2).
//            | | | |
//
//            toe.move(2, 2, 1); -> Returns 0 (no one wins)
//            |X| |O|
//            | | | |    // Player 1 makes a move at (2, 2).
//            | | |X|
//
//            toe.move(1, 1, 2); -> Returns 0 (no one wins)
//            |X| |O|
//            | |O| |    // Player 2 makes a move at (1, 1).
//            | | |X|
//
//            toe.move(2, 0, 1); -> Returns 0 (no one wins)
//            |X| |O|
//            | |O| |    // Player 1 makes a move at (2, 0).
//            |X| |X|
//
//            toe.move(1, 0, 2); -> Returns 0 (no one wins)
//            |X| |O|
//            |O|O| |    // Player 2 makes a move at (1, 0).
//            |X| |X|
//
//            toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
//            |X| |O|
//            |O|O| |    // Player 1 makes a move at (2, 1).
//            |X|X|X|
//    public static TreeNode root = null;
    public static void main(String[] args) {
        TicTacToe obj = new TicTacToe(3);
        int param_1 = -1;
        param_1 = obj.move(0, 0, 1);
        System.out.println(param_1);
        param_1 = obj.move(0, 2, 2);
        System.out.println(param_1);
        param_1 = obj.move(2, 2, 1);
        System.out.println(param_1);
        param_1 = obj.move(1, 1, 2);
        System.out.println(param_1);
        param_1 = obj.move(2, 0, 1);
        System.out.println(param_1);
        param_1 = obj.move(1, 0, 2);
        System.out.println(param_1);
        param_1 = obj.move(2, 1, 1);
        System.out.println(param_1);
    }


    public static class TicTacToe {

        /**
         * Initialize your data structure here.
         */

        private int rows[], cols[], diagonal, antiDiagonal, n;

        public TicTacToe(int n) {
            rows = new int[n];
            cols = new int[n];
            this.n = n;
        }

        public int move(int row, int col, int player) {
            int toAdd = player == 1 ? 1 : -1;           // use 1 for player 1 and -1 for player 2

            rows[row] += toAdd;
            cols[col] += toAdd;

            if (row == col) diagonal += toAdd;
            if (col == cols.length - row - 1) antiDiagonal += toAdd;

            if (rows[row] == n || cols[col] == n || diagonal == n || antiDiagonal == n)
                return 1;
            if (rows[row] == -n || cols[col] == -n || diagonal == -n || antiDiagonal == -n)
                return 2;
            return 0;
        }
    }
}