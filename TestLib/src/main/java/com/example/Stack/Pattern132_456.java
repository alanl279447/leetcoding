package com.example.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Pattern132_456 {

//    Input: [3, 1, 4, 2]
//    Output: True
//    Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
//    https://leetcode.com/problems/132-pattern/

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[] nums1={3,1,4,2};
        System.out.print(find132pattern(nums1));
    }

    public static boolean find132pattern(int[] nums) {
        if (nums.length < 3)
            return false;
        Stack < Integer > stack = new Stack < > ();
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            min[i] = Math.min(min[i - 1], nums[i]);
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j]) // i > k pop() the stack
                    stack.pop();
                if (!stack.isEmpty() && stack.peek() < nums[j])  // k < j
                    return true;
                stack.push(nums[j]);
            }
        }
        return false;
    }

//    public static int[] exclusiveTime(int n, List<String> logs) {
//        int[] result = new int[n];
//        String SPLITTER = ":";
//        String START = "start";
//        Stack<Integer> stack = new Stack<>();
//        String[] s = logs.get(0).split(SPLITTER);
//        int i = 1;
//        int prev = Integer.parseInt(s[2]);
//        stack.push(Integer.parseInt(s[0]));
//
//        while (i < logs.size()) {
//            String[] next = logs.get(i).split(SPLITTER);
//            if (next[1].equals(START)) {
//                if (!stack.isEmpty()) {
//                    result[stack.peek()] += Integer.parseInt(next[2])-prev;
//                    prev = Integer.parseInt(next[2]);
//                    stack.push(Integer.parseInt(next[0]));
//                }
//            } else {
//                  result[stack.peek()]+= Integer.parseInt(next[2]) -prev-1;
//                  stack.pop();
//                prev = Integer.parseInt(s[2]) + 1;
//            }
//            i++;
//        }
//        return result;
//    }

    public static int[] exclusiveTime(int n, List<String> logs) {
            Stack < Integer > stack = new Stack< >();
            int[] res = new int[n];
            String[] s = logs.get(0).split(":", -1);
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
