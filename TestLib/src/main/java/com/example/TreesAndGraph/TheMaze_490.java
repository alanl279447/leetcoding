package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TheMaze_490 {
//    Input 1: a maze represented by a 2D array
//
//        0 0 1 0 0
//        0 0 0 0 0
//        0 0 0 1 0
//        1 1 0 1 1
//        0 0 0 0 0
//
//    Input 2: start coordinate (rowStart, colStart) = (0, 4)
//    Input 3: destination coordinate (rowDest, colDest) = (4, 4)
//
//    Output: true
//    https://leetcode.com/problems/the-maze/

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[][] maze = {{0,0,1,0,0}, {0,0,0,0,0}, {0,0,0,1,0}, {1,1,0,1,1}, {0,0,0,0,0}};
        int[] start = {2,2};
//        int[] dest = {4,4};
        int[] dest = {3,2};
        System.out.println(hasPath(maze, start, dest));
    }

    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        Cell cell = new Cell(start[0], start[1]);
        Queue<Cell> q = new LinkedList<>();
        q.add(cell);
        while (!q.isEmpty()){
            Cell cur = q.poll();
            visited[cur.x][cur.y]=true;
            if(cur.x==destination[0] && cur.y==destination[1]) return true;
            for(int[] direction : directions) {
                int newX = cur.x;
                int newY = cur.y;
                while(isValid(maze, newX+direction[0], newY+direction[1])){   //keep going until you see a 1 or borders
                    newX+=direction[0];
                    newY+=direction[1];
                }
                if(!visited[newX][newY]) q.add(new Cell(newX, newY));
            }
        }
        return false;
    }

    private static boolean isValid(int[][] maze, int x, int y) {
        return x >= 0 && y >= 0 && x<maze.length && y<maze[0].length && maze[x][y]==0;
    }

    static class Cell {
        int x;
        int y;
        Cell(int x, int y){
            this.x=x;
            this.y=y;
        }
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
