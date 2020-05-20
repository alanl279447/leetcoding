package com.example.SortingAndSearching;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class WallsandGates_286 {

//    INF  -1  0  INF
//    INF INF INF  -1
//    INF  -1 INF  -1
//    0  -1 INF INF
//    https://leetcode.com/problems/walls-and-gates/

    public static TreeNode root = null;

    public static int[] xValues = {-1, 0, 1, 0};
    public static int[] yValues = {0, -1, 0, 1};

    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {

        int[][] rooms = {{Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0,-1, Integer.MAX_VALUE,Integer.MAX_VALUE}};

        wallsAndGates(rooms);
        for (int[] res: rooms) {
            System.out.print(res);
        }
    }

    public static void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length < 1) return;
        Queue<Cell>  queue = new ArrayDeque<>();

        //add all the
        for (int i = 0; i < rooms.length; i++) {
            for (int j =0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new Cell(i, j, 0));
                }
            }
        }

        while(!queue.isEmpty()) {
            Cell item = queue.poll();

            for (int i = 0; i < xValues.length; i++) {
              int newRow = item.row + xValues[i];
              int newColumn = item.column + yValues[i];

              if (newRow < 0 || newColumn < 0 || newRow >= rooms.length
                      || newColumn >= rooms[0].length || rooms[newRow][newColumn] != Integer.MAX_VALUE) {
                  continue;
              }
              rooms[newRow][newColumn] = rooms[item.row][item.column]+1;
              queue.offer(new Cell(newRow, newColumn, 0));
            }
        }
    }

    public static class Cell {
        int row;
        int column;
        int distance;

        public Cell(int r, int c, int d) {
           row = r;
           column = c;
           distance = d;
        }
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void addNode(int value) {
        root = addNodeRecursive(root, value);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
    }

    public static TreeNode addNodeRecursive(TreeNode node, int value) {
//        TreeNode newNode = null;
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
