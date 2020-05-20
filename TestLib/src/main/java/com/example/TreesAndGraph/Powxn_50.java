package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.List;

public class Powxn_50 {
//    Implement pow(x, n), which calculates x raised to the power n (xn).
//    Input: 2.00000, 10
//    Output: 1024.00000
//    https://leetcode.com/problems/powx-n/

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode(-10);
        int x = 9;
        System.out.print(myPow(2.0, 3));
    }

    //absN = abs(3); //0011
    //absN&1==1 ans *=num;
    //x *=x;
    //absN>>1;
    public static double myPow(double x, int n) {
        double ans = 1;
        long absN = Math.abs((long)n);
        while(absN > 0) {
            if((absN&1)==1) {
                ans *= x;
            }
            absN >>= 1;
            x *= x;
        }
        return n < 0 ?  1/ans : ans;
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
