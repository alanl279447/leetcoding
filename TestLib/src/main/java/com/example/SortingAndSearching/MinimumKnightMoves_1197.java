package com.example.SortingAndSearching;

import java.util.HashMap;
import java.util.Map;

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
//  0,0-0 1,0-3, 2,0-2, 1,1-2
//    2,1,4
//    3,2,
//    0
    public static int minKnightMoves(int x, int y) {
        Map<String, Integer> map=new HashMap<>();
        // base case
        map.put("0,0", 0);
        map.put("1,0", 3);
        map.put("1,1", 2);
        map.put("2,0", 2);
        return helper2(x,y,map);
    }

    private static int helper2(int x, int y, Map<String, Integer> map) {
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
        int optin1 = helper2(x-2,y-1,map);
        int optin2 = helper2(x-1,y-2,map);

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
