package com.example.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinStack_155 {
//    Input
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//        [[],[-2],[0],[-3],[],[],[],[]]
//    Output
//[null,null,null,null,-3,null,0,-2]
//
//    Explanation
//    MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin(); // return -3
//minStack.pop();
//minStack.top();    // return 0
//minStack.getMin(); // return -2
//    https://leetcode.com/problems/min-stack/

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        int minParam = obj.getMin();
        System.out.println(minParam);
        obj.pop();
        int topParam = obj.top();
        System.out.println(topParam);
        int minParam2 = obj.getMin();
        System.out.println(minParam2);
    }

    static class MinStack {

        /** initialize your data structure here. */
        int min = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        public void push(int x) {
            // only push the old minimum value when the current
            // minimum value changes after pushing the new value x
            if(x <= min){
                stack.push(min);
                min=x;
            }
            stack.push(x);
        }

        public void pop() {
            // if pop operation could result in the changing of the current minimum value,
            // pop twice and change the current minimum value to the last minimum value.
            if(stack.pop() == min) {
                min=stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
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
