package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestDistancefromAllBuildings_317 {
//    Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
//
//            1 - 0 - 2 - 0 - 1
//            |   |   |   |   |
//            0 - 0 - 0 - 0 - 0
//            |   |   |   |   |
//            0 - 0 - 1 - 0 - 0
//
//    Output: 7
//
//    Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
//    the point (1,2) is an ideal empty land to build a house, as the total
//    travel distance of 3+3+1=7 is minimal. So return 7.
//    https://leetcode.com/problems/shortest-distance-from-all-buildings/
//alculate distance at each empty space(0)"(which is O(m * n))
// inside of " mn time to find all 1's "(which is O(m * n )), so it will be O(m ^ 2 * n ^ 2)...
    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[][] input = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        System.out.print(shortestDistance(input));
    }

    public static int shortestDistance(int[][] grid) {
        if (grid == null || grid[0].length == 0) return 0;
        final int[] shift = new int[] {0, 1, 0, -1, 0};

        int row  = grid.length, col = grid[0].length;
        int[][] distance = new int[row][col];
        int[][] reach = new int[row][col];
        int buildingNum = 0;

        for (int i = 0; i < row; i++) {
            for (int j =0; j < col; j++) {
                if (grid[i][j] == 1) {
                    buildingNum++;
                    Queue<int[]> myQueue = new LinkedList<int[]>();
                    myQueue.offer(new int[] {i,j});

                    boolean[][] isVisited = new boolean[row][col];
                    int level = 1;

                    while (!myQueue.isEmpty()) {
                        int qSize = myQueue.size();
                        for (int q = 0; q < qSize; q++) {
                            int[] curr = myQueue.poll();

                            for (int k = 0; k < 4; k++) {
                                int nextRow = curr[0] + shift[k];
                                int nextCol = curr[1] + shift[k + 1];

                                if (nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col
                                        && grid[nextRow][nextCol] == 0 && !isVisited[nextRow][nextCol]) {
                                    //The shortest distance from [nextRow][nextCol] to thic building
                                    // is 'level'.
                                    distance[nextRow][nextCol] += level;
                                    reach[nextRow][nextCol]++;

                                    isVisited[nextRow][nextCol] = true;
                                    myQueue.offer(new int[] {nextRow, nextCol});
                                }
                            }
                        }
                        level++;
                    }
                }
            }
        }

        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildingNum) {
                    shortest = Math.min(shortest, distance[i][j]);
                }
            }
        }

        return shortest == Integer.MAX_VALUE ? -1 : shortest;


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
