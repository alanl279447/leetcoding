package com.example.ArrayStrings;

public class GameofLife_289 {
//    Input:
//            [
//            [0,1,0],
//            [0,0,1],
//            [1,1,1],
//            [0,0,0]
//            ]
//    Output:
//            [
//            [0,0,0],
//            [1,0,1],
//            [0,1,1],
//            [0,1,0]
//            ]
//    https://leetcode.com/problems/game-of-life/

//    live ->dead -1
//    dead -> live +2

    public static int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}, {-1,1}, {1,-1}, {1,1}, {-1,-1}};
    public static void main(String[] args) {
        int[][] board = {{0,1,0}, {0,0,1}, {1,1,1}, {0,0,0}};
        gameOfLife(board);
        for (int i=0;i<board.length;i++) {
            System.out.println(board[i].toString());
        }
    }

    public static void gameOfLife(int[][] board) {
       if (board == null || board.length==0) return;
       int rows = board.length;
       int cols = board[0].length;

       for (int i=0; i<rows; i++) {
        for (int j=0;j<cols;j++) {
           if (board[i][j] ==0) {
               int count = getCount(board, i,j);
               if (count ==3) {
                   board[i][j]=2;
               }
           }
           if (board[i][j] ==1) {
               int count = getCount(board, i,j);
               if (count <2 || count >3) {
                   board[i][j] =-1;
               }
           }
        }
       }
       update(board);
    }

    private static void update(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i=0; i<rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == -1) {
                    board[i][j]=0;
                }
                if (board[i][j] == 2) {
                    board[i][j]=1;
                }
            }
        }
    }

    private static int getCount(int[][] board, int row, int col) {
        int res = 0;
        for (int[] dir:dirs) {
             int newRow = dir[0] +row;
             int newCol = dir[1] + col;
             if (newRow>=0 && newRow<board.length && newCol>=0 && newCol<board[0].length
             && (board[newRow][newCol] == -1 || board[newRow][newCol] ==1))
                 res++;
         }
        return res;
    }
}
