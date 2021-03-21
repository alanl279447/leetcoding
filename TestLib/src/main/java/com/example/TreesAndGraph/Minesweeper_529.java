package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.List;

public class Minesweeper_529 {
//    Input:
//            [['E', 'E', 'E', 'E', 'E'],
//            ['E', 'E', 'M', 'E', 'E'],
//            ['E', 'E', 'E', 'E', 'E'],
//            ['E', 'E', 'E', 'E', 'E']]
//    Click : [3,0]
//            [['B', '1', 'E', '1', 'B'],
//            ['B', '1', 'M', '1', 'B'],
//            ['B', '1', '1', '1', 'B'],
//            ['B', 'B', 'B', 'B', 'B']]
//    https://leetcode.com/problems/minesweeper/

    //M unrevealed mine
    //E unrevealed empty space
    //B relvealed empty space
    //X revealed mine

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        char[][] input = {{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}};
        int[] click = {3,0};
        char[][] result = updateBoard(input, click);

        for (char[] res: result) {
            for (char c : res) {
                System.out.print(c);
            }
            System.out.println();
        }
    }


    //condition if M or X change to M and return Board
    //explore all the neighbours (-1,0), (-1,1), (0,1), (1,1), (1,0), (1,-1), (0,-1),(-1-1)

    //DFS soln
    private static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
    public static char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0], col = click[1];
        int m = board.length, n = board[0].length;

        if (board[row][col] == 'M' || board[row][col] == 'X') {
            board[row][col] = 'X';
            return board;
        }
        int num = 0;
        for (int[] dir : dirs) {
            int newRow = dir[0] + row;
            int newCol = dir[1] + col;

            if (newRow >= 0 && newRow < m &&
                    newCol >= 0 && newCol < n &&
                    (board[newRow][newCol] == 'M' || board[newRow][newCol]=='X')) {
                num++;
            }
        }
        if (num > 0) {
            board[row][col] = (char) (num + '0');
            return board;
        }
        board[row][col] = 'B';
        for (int[] dir : dirs) {
            int newRow = dir[0] + row;
            int newCol = dir[1] + col;

            if (newRow >= 0 && newRow < m &&
                    newCol >= 0 && newCol < n &&
                    board[newRow][newCol] == 'E') {
                updateBoard(board, new int[]{newRow, newCol});
            }
        }
        return board;
    }

    public static void addNode() {
        root = addNodeRecursive(root, 3);
        root.left = new TreeNode(9);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(7);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode addNodeRecursive(TreeNode node, int value) {
        if (node == null) {
            node = new TreeNode(value);
            return node;
        }

        if (value < node.val) {
            node.left = addNodeRecursive(node.left, value);
        } else if (value > node.val){
            node.right = addNodeRecursive(node.right, value);
        } else {
            return node;
        }
        return node;
    }
}
