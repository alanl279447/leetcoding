package com.example.Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ExclusiveTimeofFunctions_636 {

//    Input:
//    n = 2
//    logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
//    Output: [3, 4]
//    Explanation:
//    Function 0 starts at the beginning of time 0, then it executes 2 units of time and reaches the end of time 1.
//    Now function 1 starts at the beginning of time 2, executes 4 units of time and ends at time 5.
//    Function 0 is running again at the beginning of time 6, and also ends at the end of time 6, thus executing for 1 unit of time.
//    So function 0 spends 2 + 1 = 3 units of total time executing, and function 1 spends 4 units of total time executing.
//    https://leetcode.com/problems/exclusive-time-of-functions/

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        List<String> nums1 = Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6");
        System.out.print(exclusiveTime(2, nums1));
    }

    public static int[] exclusiveTime(int n, List<String> logs) {
            Stack < Integer > stack = new Stack< >();
            int[] res = new int[n];
            String[] s = logs.get(0).split(":");
            stack.push(Integer.parseInt(s[0]));
            int i = 1, prev = Integer.parseInt(s[2]);

            while (i < logs.size()) {
                s = logs.get(i).split(":");
                if (s[1].equals("start")) {
                    if (!stack.isEmpty()) {
                        res[stack.peek()] += Integer.parseInt(s[2]) - prev;
                    }
                    stack.push(Integer.parseInt(s[0]));
                    prev = Integer.parseInt(s[2]);
                } else {
                    res[stack.peek()] += Integer.parseInt(s[2]) - prev + 1;
                    stack.pop();
                    prev = Integer.parseInt(s[2]) + 1;
                }
                i++;
            }
            return res;
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
