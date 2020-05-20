package com.example.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinimumAddtoMakeParenthesesValid_921 {

//    Input: "())"
//    Output: 1
//    Input: "()))(("
//    Output: 4
//    https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        System.out.print(minAddToMakeValid("()))(("));
    }

    public static int minAddToMakeValid(String S) {
          int  unmatchedOpen = 0, unMatchedClose = 0;
          for (int i=0; i < S.length(); i++) {
              if (S.charAt(i)=='(') {
                  unmatchedOpen++;
              } else if (unmatchedOpen>0) {
                  unmatchedOpen--;
              } else {
                  unMatchedClose++;
              }
          }
           return unMatchedClose+unmatchedOpen;
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
