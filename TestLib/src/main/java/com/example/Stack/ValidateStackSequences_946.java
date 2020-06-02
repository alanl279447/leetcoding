package com.example.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidateStackSequences_946 {

//    For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73],
//    your output should be [1, 1, 4, 2, 1, 1, 0, 0].
//    https://leetcode.com/problems/daily-temperatures/

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.print(dailyTemperatures(T));
    }

    public static int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        if (T == null || T.length == 0) return result;
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i < T.length; i++) {
            while (!stack.isEmpty() && stack.peek() < T[i]) {
                int idx = stack.pop();
                result[idx]=i-idx;
            }
            stack.push(i);
        }
       return result;
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
