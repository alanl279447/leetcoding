package com.example.ArrayStrings;

import java.util.HashMap;
import java.util.Map;

public class FindWinnerTicTacToeGame_1275 {

//    Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
//    Output: "A"
//    Explanation: "A" wins, he always plays first.
//            "X  "    "X  "    "X  "    "X  "    "X  "
//            "   " -> "   " -> " X " -> " X " -> " X "
//            "   "    "O  "    "O  "    "OO "    "OOX"
//    https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/

    public static void main(String args[]) {
        int[][] moves = {{0,0}, {2,0}, {1,1}, {2,1}, {2,2}};
        String res = tictactoe(moves);
        System.out.println(res);
    }




    public static String tictactoe(int[][] moves) {
        int remaining = 9;
        Map<Integer, Integer> rows = new HashMap();
        Map<Integer, Integer> cols = new HashMap();
        int diag = 0, anti_diag = 0;
        int n = moves.length;
        for(int i = 0; i < n; i++){
            int[] cur = moves[i];
            int row = cur[0];
            int col = cur[1];
            int player = i % 2 == 0 ? 1 : -1;
            //check row
            rows.put(row, rows.getOrDefault(row, 0) + player);
            if(Math.abs(rows.get(row)) == 3){
                return winner(player);
            }
            //check col
            cols.put(col, cols.getOrDefault(col, 0) + player);
            if(Math.abs(cols.get(col)) == 3){
                return winner(player);
            }
            //diag:
            if(row == col){
                diag += player;
                if(Math.abs(diag) == 3){
                    return winner(player);
                }
            }
            //anti_diag: row + col  == n
            if(row + col == 2){
                anti_diag += player;
                if(Math.abs(anti_diag) == 3){
                    return winner(player);
                }
            }
            remaining--;
        }
        if(remaining == 0){
            return "Draw";
        }
        return "Pending";
    }

    private static String winner(int player){
        if(player == 1)
            return "A";
        else return "B";
    }

}
