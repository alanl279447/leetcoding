package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BattleshipsinaBoard_419 {
//    X..X
//    ...X
//    ...X
//    https://leetcode.com/problems/battleships-in-a-board/

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        char[][] input = {{'X', '.','.','X'}, {'X', '.','.','X'}, {'X', '.','.','X'}};
       System.out.println(countBattleships(input));
    }

    public int countBattleshipsFast(char[][] board) {
        int m = board.length;
        if (m==0) return 0;
        int n = board[0].length;
        int count=0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == '.') continue;
                if (i > 0 && board[i-1][j] == 'X') continue;  //count only the first occurance
                if (j > 0 && board[i][j-1] == 'X') continue;  //count only the first occurance
                count++;
            }
        }
        return count;
    }

    public static int countBattleships(char[][] board) {
        int m = board.length;
        if (m==0) return 0;
        int n = board[0].length;
        int count=0;
        List<List<point>> paths = new ArrayList<>();
        int ships = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == '.') continue;
                if (i > 0 && board[i-1][j] == 'X') {
                    paths.get(count-1).add(new point(i,j));
                    continue;
                }
                if (j > 0 && board[i][j-1] == 'X') {
                    paths.get(count-1).add(new point(i,j));
                    continue;
                }
                if(paths.size()==count) {
                    paths.add(count, new ArrayList<>());
                }
                paths.get(count).add(new point(i,j));
                count++;
            }
        }
        return count;
    }


   static public class point {
        int  pointx;
        int  pointy;
        public point(int x, int y) {
            pointx = x;
            pointy = y;
        }
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
