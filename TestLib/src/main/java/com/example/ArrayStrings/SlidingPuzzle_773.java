package com.example.ArrayStrings;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/sliding-puzzle/
//        Input: board = [[1,2,3],[4,0,5]]
//        Output: 1
//        Explanation: Swap the 0 and the 5 in one move.


public class SlidingPuzzle_773 {
    public static void main(String[] args) {
        //int[][] trips = {{1,2,3}, {4,0,5}};
        int[][] tripsTest = {{4,1,2},{5,0,3}};
        System.out.println(slidingPuzzleTest(tripsTest));
    }

    public static int slidingPuzzleTest(int[][] board) {
       String target = "123450";
       StringBuilder start = new StringBuilder();

       for (int i = 0; i < board.length; i++) {
           for (int j =0; j < board[0].length; j++) {
               start.append(board[i][j]);     //123405
           }
       }
       //0 1 2
       //3 4 5
       Set<String> visited = new HashSet<>();
       Queue<String> queue = new LinkedList<>();

       visited.add(start.toString());
       queue.offer(start.toString());

       int[][] directions = {{1,3}, {0,2,4}, {1,5}, {0,4}, {1,3,5}, {2,4}};
       int steps = 0;
       while (!queue.isEmpty()) {
           int size = queue.size();
           for (int i = 0; i < size; i++) {
               String curr = queue.poll();
               if (curr.equals(target)) {
                   return steps;
               }
               int zeroIndex = curr.indexOf('0');
               for (int dir : directions[zeroIndex]) {
                   String nextSring = swapTest(curr, zeroIndex, dir);
                   if (visited.contains(nextSring)) {
                       continue;
                   }
                   System.out.println(nextSring);
                   queue.offer(nextSring);
                   visited.add(nextSring);
               }
           }
           steps++;
       }
       return -1;
    }

    public static String swapTest(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }

    public static int slidingPuzzle(int[][] board) {
        String target = "123450";
        String start = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                start += board[i][j];
            }
        }
        HashSet<String> visited = new HashSet<>();
        // all the positions 0 can be swapped to
        int[][] dirs = new int[][] { { 1, 3 }, { 0, 2, 4 },
                { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        int res = 0;
        while (!queue.isEmpty()) {
            // level count, has to use size control here, otherwise not needed
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return res;
                }
                int zero = cur.indexOf('0');
                // swap if possible
                for (int dir : dirs[zero]) {
                    String next = swap(cur, zero, dir);
                    if (visited.contains(next)) {
                        continue;
                    }
                    System.out.println(next);
                    visited.add(next);
                    queue.offer(next);
                }
            }
            res++;
        }
        return -1;
    }

    private static String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}