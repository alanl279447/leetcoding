package com.example.SortingAndSearching;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MinimumKnightMoves_1197 {

//    Input: x = 5, y = 5
//    Output: 4
//    Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
//    https://leetcode.com/problems/minimum-knight-moves/

    public static TreeNode root = null;
    public static void main(String[] args) {
        int result = minKnightMoves(5, 5);
        System.out.println(result);
    }

    private final int[][] DIRECTIONS = new int[][] {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    public int minKnightMovesBFS(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        Set<String> visited = new HashSet<>();
        visited.add("0,0");

        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                int curX = cur[0];
                int curY = cur[1];
                if (curX == x && curY == y) {
                    return result;
                }

                for (int[] d : DIRECTIONS) {
                    int newX = curX + d[0];
                    int newY = curY + d[1];
                    if (!visited.contains(newX + "," + newY) && newX >= -1 && newY >= -1) {
                        queue.add(new int[] {newX, newY});
                        visited.add(newX + "," + newY);
                    }
                }
            }
            result++;
        }
        return -1;
    }


  //  0,0-0 1,0-3, 2,0-2, 1,1-2
//    2,1,4/
//    3,2/,1
//    0/,3,2

// 5
// 4   2  3  2 3
// 3   3  2 3/ 2
// 2   2  1/4  3
// 1   3 /2 1  2
// 0   /0 3 2  3

    public static int minKnightMoves(int x, int y) {
        Map<String, Integer> map=new HashMap<>();
        // base case
        map.put("0,0", 0);
        map.put("1,0", 3);
        map.put("1,1", 2);
        map.put("0,1", 3);
        return dfs(x,y,map);
    }

    private static int dfs(int x, int y, Map<String, Integer> map) {
        // Sysmetrical of axis
        x=Math.abs(x);
        y=Math.abs(y);
        // Sysmetrical of diagonal
        if(x<y) {
            int temp=x;
            x=y;
            y=temp;
        }
        String s=x+","+y;
        if(map.containsKey(s)) {
            return map.get(s);
        }
        int optin1 = dfs(x-2,y-1,map);
        int optin2 = dfs(x-1,y-2,map);

        int temp=Math.min(optin1, optin2)+1;
        map.put(s, temp);
        return temp;
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
