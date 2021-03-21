package com.example.HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class IslandPerimeter_463 {
//    Input:
//            [[0,1,0,0],
//            [1,1,1,0],
//            [0,1,0,0],
//            [1,1,0,0]]
//    Output: 16
//    Explanation: The perimeter is the 16 yellow stripes in the image below:
//    https://leetcode.com/problems/island-perimeter/

//    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[][] input = {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
        int res = islandPerimeter(input);
        System.out.println(res);
    }

    public static int islandPerimeter(int[][] grid) {
       int noOfIslands = 0;
       for (int i =0; i < grid.length; i++) {
           for (int j=0; j<grid[0].length; j++) {
               if (grid[i][j]==1) {
                   noOfIslands  = noOfIslands + 4;
                   if (i > 0 && grid[i-1][j] == 1) {
                       noOfIslands = noOfIslands - 2;
                   }
                   if (j > 0 && grid[i][j-1] ==1) {
                       noOfIslands = noOfIslands - 2;
                   }
               }
           }
       }
       return noOfIslands;
    }
}
