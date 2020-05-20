package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FriendCircles547 {

//    Input:
//            [[1,1,0],
//            [1,1,0],
//            [0,0,1]]
//    Output: 2
//    Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
//            The 2nd student himself is in a friend circle. So return 2.
//    https://leetcode.com/problems/friend-circles/

    public static TreeNode root;
    private static TreeNode ans = null;

    public static void main(String[] args) {
        //addNode(1);
        //int[][] input = {{1,1,0}, {1,1,0}, {0,0,1}};
        int[][] input = {{1,1,0}, {1,1,1}, {0,1,1}};
        int result = findCircleNum(input);
//        for(String res: result)
          System.out.println(result);
    }

    public static int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length]; //visited[i] means if ith person is visited in this algorithm
        int count = 0;
        for(int i = 0; i < M.length; i++) {
            if(!visited[i]) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
    private static void dfs(int[][] M, boolean[] visited, int person) {
        for(int other = 0; other < M.length; other++) {
            if(M[person][other] == 1 && !visited[other]) {
                //We found an unvisited person in the current friend cycle
                visited[other] = true;
                dfs(M, visited, other); //Start DFS on this new found person
            }
        }
    }


    public static void addNode(int value) {
        root = new TreeNode(value);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
    }

    public static class Node {
        TreeNode node;
        int hd;

        public Node(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
